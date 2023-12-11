import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static Point start;
    public static int bfs_search(int[][] road, int n) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        Point dot = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int target = -1, depth = 0;

        queue.add(start);
        visit[start.x][start.y] = true;

        if(road[start.x][start.y] != 0) {
            road[start.x][start.y] = 0;
            return depth;
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int l = 0; l < len; l++) {
                Point now = queue.poll();

                for(int[] d : delta) {
                    int nr = now.x + d[0];
                    int nc = now.y + d[1];

                    if(nr < 0 || nr >= n || nc < 0 || nc >= n || road[nr][nc] == -1 || visit[nr][nc]) continue;

                    queue.add(new Point(nr, nc));
                    visit[nr][nc] = true;

                    if(road[nr][nc] >= 1 && (nr < dot.x || (nr == dot.x && nc < dot.y))) {
                        dot = new Point(nr, nc);
                        target = road[nr][nc];
                    }
                }
            }

            depth++;

            if(target != -1) {
                start = dot;
                road[start.x][start.y] = 0;
                return depth;
            }
        }

        return -1;
    }
    public static int bfs_go(int[][] road, Point end, int n) {
        Queue<Point> queue = new LinkedList<>();
        int[][] visit = new int[n][n];

        queue.add(start);
        visit[start.x][start.y] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int[] d : delta) {
                int nr = now.x + d[0];
                int nc = now.y + d[1];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc] != 0 || road[nr][nc] == -1) continue;

                queue.add(new Point(nr, nc));
                visit[nr][nc] = visit[now.x][now.y] + 1;

                if(nr == end.x && nc == end.y) {
                    start = end;
                    return visit[nr][nc] - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] road = new int[n][n];
        Map<Point, Point> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < n; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
                if(road[i][j] == 1) road[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        start = new Point(r, c);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            road[r1][c1] = i + 1;

            map.put(new Point(r1, c1), new Point(r2, c2));
        }

        for(int i = 0; i < m; i++) {
            int result1 = bfs_search(road, n);

            if(e <= result1 || result1 == -1) {
                e = -1;
                break;
            }

            e -= result1;

            int result2 = bfs_go(road, map.get(start), n);

            if(e < result2 || result2 == -1) {
                e = -1;
                break;
            }

            e += result2;
        }

        bw.write(e + "");
        bw.close();
    }
}