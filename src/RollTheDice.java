import java.util.*;
import java.io.*;

public class RollTheDice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[][] placements = new String[N][3];

        for (int i = 0; i < N; i++) placements[i] = br.readLine().trim().split(" ");

        Map<Integer, Coordinate> idToCoord = buildGrid(placements);

        String[] srcDest = br.readLine().trim().split(" ");
        int start = Integer.parseInt(srcDest[0]), target = Integer.parseInt(srcDest[1]);

        String[] initFaces = br.readLine().trim().split(" ");
        int top = Integer.parseInt(initFaces[0]);
        int left = Integer.parseInt(initFaces[1]);
        int front = Integer.parseInt(initFaces[2]);

        Map<Integer, List<Object[]>> adjacency = buildAdjacency(idToCoord);

        long result = minRollCost(start, target, top, left, front, adjacency);
        System.out.print(result);
    }

    // --- 1. Core Data Structures ---

    static class Coordinate {
        final int col, row;

        Coordinate(int col, int row) { this.col = col; this.row = row; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate c = (Coordinate) o;
            return col == c.col && row == c.row;
        }

        @Override
        public int hashCode() { return Objects.hash(col, row); }
    }

    static class SearchNode implements Comparable<SearchNode> {
        final long totalCost;
        final int blockID;
        final int topFace, leftFace, frontFace;

        SearchNode(long cost, int id, int top, int left, int front) {
            totalCost = cost;
            blockID = id;
            topFace = top;
            leftFace = left;
            frontFace = front;
        }

        @Override
        public int compareTo(SearchNode other) {
            return Long.compare(totalCost, other.totalCost);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SearchNode)) return false;
            SearchNode s = (SearchNode) o;
            return blockID == s.blockID &&
                    topFace == s.topFace &&
                    leftFace == s.leftFace &&
                    frontFace == s.frontFace;
        }

        @Override
        public int hashCode() {
            return Objects.hash(blockID, topFace, leftFace, frontFace);
        }
    }

    // --- 2. Movement Data ---

    static final String[] DIRECTIONS = {"left", "right", "top", "down"};
    static final Map<String, int[]> DELTAS = Map.of(
            "left", new int[]{0, -1},
            "right", new int[]{0, 1},
            "top", new int[]{1, 0},
            "down", new int[]{-1, 0}
    );

    // --- 3. Utility Methods ---

    // Roll the die based on direction
    static int[] rollDie(int top, int left, int front, String dir) {
        int bottom = 7 - top, right = 7 - left, back = 7 - front;
        switch (dir) {
            case "right": return new int[]{left, bottom, front};
            case "left":  return new int[]{right, top, front};
            case "top":   return new int[]{front, left, bottom};
            case "down":  return new int[]{back, left, top};
            default:      return new int[]{top, left, front};
        }
    }

    // Build mapping of cube ID -> Coordinate
    static Map<Integer, Coordinate> buildGrid(String[][] placements) {
        Map<Integer, Coordinate> idToCoord = new HashMap<>();
        Map<Coordinate, Integer> coordToID = new HashMap<>();

        Arrays.sort(placements, (a, b) -> {
            int cmp = Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
            if (cmp != 0) return cmp;
            return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
        });

        int firstID = Integer.parseInt(placements[0][0]);
        idToCoord.put(firstID, new Coordinate(0, 0));
        coordToID.put(new Coordinate(0, 0), firstID);

        for (String[] p : placements) {
            int a = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);
            String dir = p[2];

            if (!idToCoord.containsKey(a)) continue;

            Coordinate coordA = idToCoord.get(a);
            int[] delta = DELTAS.get(dir);
            Coordinate coordB = new Coordinate(coordA.col + delta[0], coordA.row + delta[1]);

            if (!coordToID.containsKey(coordB)) {
                idToCoord.put(b, coordB);
                coordToID.put(coordB, b);
            }
        }
        return idToCoord;
    }

    // Build adjacency list for graph
    static Map<Integer, List<Object[]>> buildAdjacency(Map<Integer, Coordinate> idToCoord) {
        Map<Coordinate, Integer> coordToID = new HashMap<>();
        idToCoord.forEach((id, coord) -> coordToID.put(coord, id));

        Map<Integer, List<Object[]>> adj = new HashMap<>();

        for (var entry : idToCoord.entrySet()) {
            int id = entry.getKey();
            Coordinate coord = entry.getValue();
            for (String dir : DIRECTIONS) {
                int[] delta = DELTAS.get(dir);
                Coordinate neighbor = new Coordinate(coord.col + delta[0], coord.row + delta[1]);
                if (coordToID.containsKey(neighbor)) {
                    adj.computeIfAbsent(id, k -> new ArrayList<>())
                            .add(new Object[]{coordToID.get(neighbor), dir});
                }
            }
        }
        return adj;
    }

    // --- 4. Dijkstra's algorithm variant for die rolling ---
    static long minRollCost(int start, int target, int top, int left, int front,
                            Map<Integer, List<Object[]>> adjacency) {

        PriorityQueue<SearchNode> pq = new PriorityQueue<>();
        Set<SearchNode> visited = new HashSet<>();
        pq.add(new SearchNode(0, start, top, left, front));

        while (!pq.isEmpty()) {
            SearchNode node = pq.poll();
            if (visited.contains(node)) continue;
            visited.add(node);

            if (node.blockID == target) return node.totalCost;

            if (adjacency.containsKey(node.blockID)) {
                for (Object[] neighborInfo : adjacency.get(node.blockID)) {
                    int nextID = (Integer) neighborInfo[0];
                    String dir = (String) neighborInfo[1];
                    int[] newFaces = rollDie(node.topFace, node.leftFace, node.frontFace, dir);
                    SearchNode next = new SearchNode(node.totalCost + newFaces[0], nextID, newFaces[0], newFaces[1], newFaces[2]);
                    if (!visited.contains(next)) pq.add(next);
                }
            }
        }
        return -1;
    }
}
