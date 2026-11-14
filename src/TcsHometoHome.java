import java.util.*;

public class TcsHometoHome {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        @Override
        public int hashCode() {
            return x * 10007 + y; // prime to reduce collisions
        }
        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    static boolean isOnSegment(Point p, Point a, Point b) {
        long cross = (long) (p.x - a.x) * (b.y - a.y) - (long) (p.y - a.y) * (b.x - a.x);
        if (cross != 0) return false;
        return Math.min(a.x, b.x) <= p.x && p.x <= Math.max(a.x, b.x) &&
                Math.min(a.y, b.y) <= p.y && p.y <= Math.max(a.y, b.y);
    }

    static int distSq(Point a, Point ref) {
        return (a.x - ref.x) * (a.x - ref.x) + (a.y - ref.y) * (a.y - ref.y);
    }

    static void dfs(int curr, int parent, int pathLen, boolean[] visited, List<List<Integer>> adj, int start, long[] cnt) {
        for (int nei : adj.get(curr)) {
            if (nei == parent) continue;
            if (visited[nei]) {
                if (nei == start && pathLen + 1 >= 3) {
                    cnt[0]++;
                }
            } else {
                visited[nei] = true;
                dfs(nei, curr, pathLen + 1, visited, adj, start, cnt);
                visited[nei] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Point[]> segments = new ArrayList<>();
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            Point a = new Point(x1, y1);
            Point b = new Point(x2, y2);
            segments.add(new Point[]{a, b});
            pointSet.add(a);
            pointSet.add(b);
        }
        int hx = sc.nextInt(), hy = sc.nextInt();
        Point house = new Point(hx, hy);
        pointSet.add(house);
        List<Point> points = new ArrayList<>(pointSet);
        int M = points.size();
        Map<Point, Integer> idMap = new HashMap<>();
        for (int i = 0; i < M; i++) {
            idMap.put(points.get(i), i);
        }
        int start = idMap.get(house);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < M; i++) adj.add(new ArrayList<>());
        for (Point[] seg : segments) {
            Point a = seg[0], b = seg[1];
            List<Point> listOn = new ArrayList<>();
            for (Point p : points) {
                if (isOnSegment(p, a, b)) {
                    listOn.add(p);
                }
            }
            if (listOn.size() < 2) continue;
            listOn.sort((p1, p2) -> Integer.compare(distSq(p1, a), distSq(p2, a)));
            for (int i = 0; i < listOn.size() - 1; i++) {
                Point p1 = listOn.get(i);
                Point p2 = listOn.get(i + 1);
                int u = idMap.get(p1);
                int v = idMap.get(p2);
                if (!adj.get(u).contains(v)) {
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        boolean[] visited = new boolean[M];
        long[] cnt = {0};
        visited[start] = true;
        for (int nei : adj.get(start)) {
            visited[nei] = true;
            dfs(nei, start, 1, visited, adj, start, cnt);
            visited[nei] = false;
        }
        long unique = cnt[0] / 2;
        System.out.println(unique);
        sc.close();
    }
}