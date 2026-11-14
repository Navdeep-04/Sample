import java.util.*;
import java.io.*;

public class TcsRollTheDice {

    // --- 1. Core Data Structures ---

    /** Represents a cube's 2D grid coordinate (Advanced: used for grid mapping). */
    static class Coordinate {
        final int col, row;
        public Coordinate(int c, int r) { this.col = c; this.row = r; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate c = (Coordinate) o;
            return col == c.col && row == c.row;
        }
        @Override
        public int hashCode() { return Objects.hash(col, row); }
    }

    /** Represents the state of the die (orientation) and position in the search (Advanced: State Space Node). */
    static class SearchNode implements Comparable<SearchNode> {
        final long totalCost;
        final int blockID;
        final int topFace, leftFace, frontFace;

        public SearchNode(long cost, int id, int top, int left, int front) {
            this.totalCost = cost;
            this.blockID = id;
            this.topFace = top;
            this.leftFace = left;
            this.frontFace = front;
        }

        // Compare primarily by cost
        @Override
        public int compareTo(SearchNode other) {
            return Long.compare(this.totalCost, other.totalCost);
        }

        // Only blockID and faces define a unique visited state
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SearchNode s = (SearchNode) o;
            return blockID == s.blockID && topFace == s.topFace && leftFace == s.leftFace && frontFace == s.frontFace;
        }

        @Override
        public int hashCode() {
            return Objects.hash(blockID, topFace, leftFace, frontFace);
        }
    }

    // --- 2. Global Mappings (Renamed from DX/DY) ---

    // Movement vectors: map direction string to (col_delta, row_delta)
    static final Map<String, Integer> COL_DELTA;
    static final Map<String, Integer> ROW_DELTA;
    static final String[] MOVES = {"left", "right", "top", "down"};

    static {
        COL_DELTA = new HashMap<>(); COL_DELTA.put("left", -1); COL_DELTA.put("right", 1); COL_DELTA.put("top", 0); COL_DELTA.put("down", 0);
        ROW_DELTA = new HashMap<>(); ROW_DELTA.put("left", 0); ROW_DELTA.put("right", 0); ROW_DELTA.put("top", 1); ROW_DELTA.put("down", -1);
    }

    // --- 3. New Methods for Encapsulation ---

    /**
     * Simulates the die roll.
     * @return An array {newTop, newLeft, newFront}.
     */
    static int[] performRoll(int t, int l, int f, String direction) {
        // Faces: t=top, l=left, f=front. Opposites: (7-t), (7-l), (7-f)
        int b = 7 - t; // Bottom
        int r = 7 - l; // Right
        int k = 7 - f; // Back

        int nt = t, nl = l, nf = f;

        switch (direction) {
            case "right":
                nt = l; nl = b; break;
            case "left":
                nt = r; nl = t; break;
            case "top": // Rolling over the Front face
                nt = f; nf = b; break;
            case "down": // Rolling over the Back face
                nt = k; nf = t; break;
        }
        return new int[]{nt, nl, nf};
    }

    /**
     * Builds the grid of cube coordinates from the placement instructions.
     * @return A map: Cube ID -> Coordinate
     */
    static Map<Integer, Coordinate> buildBlockGrid(BufferedReader br, int N, String[][] placements) throws IOException {

        // Map: Coordinate -> Cube ID (inverse lookup)
        Map<Coordinate, Integer> coordToID = new HashMap<>();
        // Map: Cube ID -> Coordinate (primary output)
        Map<Integer, Coordinate> idToCoord = new HashMap<>();

        // 1. Sort placements (numerical comparison)
        Arrays.sort(placements, (p1, p2) -> {
            int a1 = Integer.parseInt(p1[0]);
            int a2 = Integer.parseInt(p2[0]);
            if (a1 != a2) return Integer.compare(a1, a2);
            int b1 = Integer.parseInt(p1[1]);
            int b2 = Integer.parseInt(p2[1]);
            return Integer.compare(b1, b2);
        });

        // 2. Initialize the first block at (0, 0)
        int initialID = Integer.parseInt(placements[0][0]);
        Coordinate initialCoord = new Coordinate(0, 0);
        idToCoord.put(initialID, initialCoord);
        coordToID.put(initialCoord, initialID);

        // 3. Process all placements sequentially
        for (String[] placement : placements) {
            int blockA = Integer.parseInt(placement[0]);
            int blockB = Integer.parseInt(placement[1]);
            String moveDir = placement[2];

            if (!idToCoord.containsKey(blockA)) continue;

            Coordinate coordA = idToCoord.get(blockA);
            int newCol = coordA.col + COL_DELTA.get(moveDir);
            int newRow = coordA.row + ROW_DELTA.get(moveDir);
            Coordinate coordB = new Coordinate(newCol, newRow);

            if (coordToID.containsKey(coordB)) continue;

            idToCoord.put(blockB, coordB);
            coordToID.put(coordB, blockB);
        }
        return idToCoord;
    }

    /**
     * Builds the adjacency list for the graph of blocks (ID -> List of [Neighbor ID, Direction]).
     */
    static Map<Integer, List<Object[]>> buildAdjacencyList(Map<Integer, Coordinate> idToCoord) {
        Map<Coordinate, Integer> coordToID = new HashMap<>();
        for (Map.Entry<Integer, Coordinate> entry : idToCoord.entrySet()) {
            coordToID.put(entry.getValue(), entry.getKey());
        }

        Map<Integer, List<Object[]>> neighbors = new HashMap<>();

        for (Map.Entry<Integer, Coordinate> entry : idToCoord.entrySet()) {
            int currentID = entry.getKey();
            Coordinate currentCoord = entry.getValue();

            for (String direction : MOVES) {
                int nextCol = currentCoord.col + COL_DELTA.get(direction);
                int nextRow = currentCoord.row + ROW_DELTA.get(direction);
                Coordinate nextCoord = new Coordinate(nextCol, nextRow);

                if (coordToID.containsKey(nextCoord)) {
                    int neighborID = coordToID.get(nextCoord);
                    // Store as [Neighbor ID, Direction String]
                    neighbors.computeIfAbsent(currentID, k -> new ArrayList<>()).add(new Object[]{neighborID, direction});
                }
            }
        }
        return neighbors;
    }

    /**
     * Implements the shortest path finding using Dijkstra's algorithm.
     */
    static long findMinimumRollCost(
            int startID, int targetID, int initTop, int initLeft, int initFront,
            Map<Integer, List<Object[]>> adjacency
    ) {
        PriorityQueue<SearchNode> frontier = new PriorityQueue<>();
        Set<SearchNode> exploredStates = new HashSet<>();

        // Start Node
        frontier.offer(new SearchNode(0, startID, initTop, initLeft, initFront));

        while (!frontier.isEmpty()) {
            SearchNode current = frontier.poll();

            // Check if this specific state (ID and orientation) has been processed
            if (exploredStates.contains(current)) continue;
            exploredStates.add(current);

            // Goal Check
            if (current.blockID == targetID) {
                return current.totalCost;
            }

            // Expand neighbors
            if (adjacency.containsKey(current.blockID)) {
                for (Object[] neighborInfo : adjacency.get(current.blockID)) {
                    int nextID = (Integer) neighborInfo[0];
                    String rollDir = (String) neighborInfo[1];

                    // Calculate new die state
                    int[] newFaces = performRoll(current.topFace, current.leftFace, current.frontFace, rollDir);
                    int nextTop = newFaces[0];
                    int nextLeft = newFaces[1];
                    int nextFront = newFaces[2];

                    // The cost of the step is the value on the new top face
                    long newTotalCost = current.totalCost + nextTop;

                    SearchNode nextState = new SearchNode(newTotalCost, nextID, nextTop, nextLeft, nextFront);

                    // Add to frontier if not already processed
                    if (!exploredStates.contains(nextState)) {
                        // Note: We don't need explicit distance tracking (like a 'dist' map)
                        // because Dijkstra's with a proper visited set handles path relaxation implicitly.
                        frontier.offer(nextState);
                    }
                }
            }
        }

        return -1; // Path not found
    }

    // --- 4. Main Method ---

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N
        int N = Integer.parseInt(br.readLine().trim());

        // Read all placements
        String[][] placements = new String[N][3];
        for (int i = 0; i < N; i++) {
            placements[i] = br.readLine().trim().split(" ");
        }

        // Build the grid mapping
        Map<Integer, Coordinate> idToCoord = buildBlockGrid(br, N, placements);

        // Read source, destination, and initial die faces
        String[] line = br.readLine().trim().split(" ");
        int startID = Integer.parseInt(line[0]);
        int targetID = Integer.parseInt(line[1]);

        line = br.readLine().trim().split(" ");
        int initTop = Integer.parseInt(line[0]);
        int initLeft = Integer.parseInt(line[1]);
        int initFront = Integer.parseInt(line[2]);

        // Build the adjacency graph for the search
        Map<Integer, List<Object[]>> adjacency = buildAdjacencyList(idToCoord);

        // Find the shortest path cost
        long resultCost = findMinimumRollCost(
                startID, targetID, initTop, initLeft, initFront, adjacency
        );

        // Output the result
        System.out.print(resultCost);
    }
}