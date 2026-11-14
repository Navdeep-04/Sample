

import java.util.*;

    public class SecretKey {

        static int rows, cols, keyLength, clues;
        static char[][] grid;
        static List<int[]>[] allowedPositions;
        static List<String> possibleKeys = new ArrayList<>();

        // Exclude subgrid positions based on clues
        static void excludeSubgrid(int time, int x1, int y1, int x2, int y2) {
            // If first clue for this time, initially allow all positions
            if (allowedPositions[time].isEmpty()) {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        allowedPositions[time].add(new int[]{i, j});
                    }
                }
            }

            // Remove cells inside the restricted region
            List<int[]> updated = new ArrayList<>();
            for (int[] pos : allowedPositions[time]) {
                int x = pos[0], y = pos[1];
                // Keep only positions outside the excluded subgrid
                if (x < x1 || x > x2 || y < y1 || y > y2) {
                    updated.add(pos);
                }
            }
            allowedPositions[time] = updated;
        }

        // Recursive DFS to explore valid key paths
        static void explorePath(int x, int y, int time, boolean[][] visited, String path) {
            // Base case: If full key formed
            if (time == keyLength) {
                possibleKeys.add(path);
                return;
            }

            int nextTime = time + 1;
            int[] dx = {-1, 1, 0, 0};  // movement: up, down, left, right
            int[] dy = {0, 0, -1, 1};

            // Try all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // Check boundaries and visited condition
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                    // Check if next position is valid for next time
                    for (int[] allowed : allowedPositions[nextTime]) {
                        if (allowed[0] == nx && allowed[1] == ny) {
                            visited[nx][ny] = true;
                            explorePath(nx, ny, nextTime, visited, path + grid[nx][ny]);
                            visited[nx][ny] = false;
                            break;
                        }
                    }
                }
            }
        }

        // Initialize all positions using enhanced for-loop
        static void fillAllPositions() {
            for (int t = 1; t <= keyLength; t++) {
                if (allowedPositions[t].isEmpty()) {
                    // Using "for-each" with range to make code cleaner
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            allowedPositions[t].add(new int[]{i, j});
                        }
                    }
                }
            }
        }

        // Check if any time step is invalid using streams
        static boolean hasEmptyTimeStep() {
            for (int t = 1; t <= keyLength; t++) {
                if (allowedPositions[t].isEmpty()) return true;
            }
            return false;
            // OR (alternate modern way)
            // return IntStream.rangeClosed(1, keyLength).anyMatch(t -> allowedPositions[t].isEmpty());
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            //  1: Input grid dimensions
            rows = sc.nextInt();
            cols = sc.nextInt();
            sc.nextLine();

            //  2: Input grid values
            grid = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = line[j].charAt(0);
                }
            }

            //  3: Key length and clue count
            keyLength = sc.nextInt();
            clues = sc.nextInt();

            // Initialize allowed positions for each time step
            allowedPositions = new ArrayList[keyLength + 1];
            for (int i = 1; i <= keyLength; i++) {
                allowedPositions[i] = new ArrayList<>();
            }

            //  4: Read clues
            for (int i = 0; i < clues; i++) {
                int t = sc.nextInt();
                int x1 = sc.nextInt() - 1;
                int y1 = sc.nextInt() - 1;
                int x2 = sc.nextInt() - 1;
                int y2 = sc.nextInt() - 1;
                excludeSubgrid(t, x1, y1, x2, y2);
            }

            //  5: Fill missing allowed positions
            fillAllPositions();

            //  6: Validate time steps
            if (hasEmptyTimeStep()) {
                System.out.println("Not enough clues");
                return;
            }

            //  7: Explore paths from every valid start position
            for (int[] start : allowedPositions[1]) {
                boolean[][] visited = new boolean[rows][cols];
                visited[start[0]][start[1]] = true;
                explorePath(start[0], start[1], 1, visited, "" + grid[start[0]][start[1]]);
            }

            //  8: Output final result
            if (possibleKeys.size() == 1) {
                System.out.println(possibleKeys.get(0));
            } else {
                System.out.println("Not enough clues");
            }

            sc.close();
        }
    }

