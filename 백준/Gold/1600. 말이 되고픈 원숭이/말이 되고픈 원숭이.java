import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int r;
        int c;
        int jump;

        Point(int r, int c, int jump) {
            this.r = r;
            this.c = c;
            this.jump = jump;
        }
    }

    public static void bfs(int[][] map, int k) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[map.length][map[0].length][k + 1];
        int[][] distance = new int[map.length][map[0].length];
        int[][] delta = {{1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue.offer(new Point(0, 0, 0));

        for(int i = 0; i < k; i++) visit[0][0][i] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int jump = now.jump;

            for(int i = 0; i < 12; i++) {
                int next_r = now.r + delta[i][0];
                int next_c = now.c + delta[i][1];

                if(next_r < 0 || next_r >= map.length || next_c < 0 || next_c >= map[0].length) continue;

                if(map[next_r][next_c] == 0 && i < 8 && jump < k && !visit[next_r][next_c][jump + 1]) {
                    visit[next_r][next_c][jump + 1] = true;
                    distance[next_r][next_c] = distance[now.r][now.c] + 1;
                    queue.offer(new Point(next_r, next_c, jump + 1));
                }
                else if(map[next_r][next_c] == 0 && i >= 8 && !visit[next_r][next_c][jump]) {
                    visit[next_r][next_c][jump] = true;
                    distance[next_r][next_c] = distance[now.r][now.c] + 1;
                    queue.offer(new Point(next_r, next_c, jump));
                }

                if(next_r == map.length - 1 && next_c == map[0].length - 1 && distance[next_r][next_c] != 0) {
                    System.out.println(distance[map.length - 1][map[0].length - 1]);
                    return;
                }
            }
        }

        if(map.length == 1 && map[0].length == 1) System.out.println("0");
        else System.out.println("-1");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(map, k);
    }
}