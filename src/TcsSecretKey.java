import java.util.*;
public class TcsSecretKey {
        static int W, X, Y, Z;
        static char[][] matrix;
        static List<int[]>[] possiPos;
        static List<String> valPath = new ArrayList<>();

        static void markEx(int k, int a1, int b1, int a2, int b2) {
            // If this is the first constraint for time t, initialize with all positions
            if (possiPos[k].isEmpty()) {
                for (int i = 0; i < W; i++) {
                    for (int j = 0; j < X; j++) {
                        possiPos[k].add(new int[]{i, j});
                    }
                }
            }

            // Remove positions that are in the excluded subgrid
            List<int[]> newPossi = new ArrayList<>();
            for (int[] pos : possiPos[k]) {
                int a = pos[0], b = pos[1];
                // Keep position only if it's NOT in the excluded subgrid
                if (a < a1 || a > a2 || b < b1 || b > b2) {
                    newPossi.add(pos);
                }
            }
            possiPos[k] = newPossi;
        }

        static void dataFields(int m, int n, int timePeriod, boolean[][] seek, String track) {
            if (timePeriod == Y) {
                valPath.add(track);
                return;
            }

            int upcomingTime = timePeriod + 1;

            // Try all four directions
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nx = m + dx[i];
                int ny = n + dy[i];

                // Check bounds and if not visited
                if (nx >= 0 && nx < W && ny >= 0 && ny < X && !seek[nx][ny]) {
                    // Check if this position is possible at next time
                    boolean validForNextTime = false;
                    for (int[] position : possiPos[upcomingTime]) {
                        if (position[0] == nx && position[1] == ny) {
                            validForNextTime = true;
                            break;
                        }
                    }

                    if (validForNextTime) {
                        seek[nx][ny] = true;
                        dataFields(nx, ny, upcomingTime, seek, track + matrix[nx][ny]);
                        seek[nx][ny] = false;
                    }
                }
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read grid dimensions
        W = sc.nextInt();
        X = sc.nextInt();
        sc.nextLine();

        // Read grid
        matrix = new char[W][X];
        for (int i = 0; i < W; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < X; j++) {
                matrix[i][j] = row[j].charAt(0);
            }
        }

        // Read key length and number of clues
        Y = sc.nextInt();
        Z = sc.nextInt();

        // Initialize possible positions for each time step
        possiPos = new ArrayList[Y + 1];
        for (int i = 1; i <= Y; i++) {
            possiPos[i] = new ArrayList<>();
        }

        // Read clues and determine possible positions
        for (int i = 0; i < Z; i++) {
            int t = sc.nextInt();
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;

            // Mark the subgrid as excluded for time t
            markEx(t, x1, y1, x2, y2);
        }

        // Initialize possible positions for all time steps
        for (int t = 1; t <= Y; t++) {
            if (possiPos[t].isEmpty()) {
                // If no constraints, all positions are possible
                for (int i = 0; i < W; i++) {
                    for (int j = 0; j < X; j++) {
                        possiPos[t].add(new int[]{i, j});
                    }
                }
            }
        }

        // Check if any time step has no possible positions
        for (int t = 1; t <= Y; t++) {
            if (possiPos[t].isEmpty()) {
                System.out.println("Not enough clues");
                return;
            }
        }

        // Find all valid paths
        for (int[] start : possiPos[1]) {
            boolean[][] visited = new boolean[W][X];
            visited[start[0]][start[1]] = true;
            dataFields(start[0], start[1], 1, visited, "" + matrix[start[0]][start[1]]);
        }

        // Check results
        if (valPath.size() == 1) {
            System.out.println(valPath.get(0));
        } else {
            System.out.println("Not enough clues");
        }
    }
}

