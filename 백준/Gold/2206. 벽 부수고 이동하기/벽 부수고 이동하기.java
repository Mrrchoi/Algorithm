import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int r;
        int c;
        int wall;

        Point(int r, int c, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
        }
    }

    public static void bfs(int[][] map) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[map.length][map[0].length][2];
        int[][] distance = new int[map.length][map[0].length];
        int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue.offer(new Point(0, 0, 0));
        visit[0][0][0] = visit[0][0][1] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int wall = now.wall;

            for(int i = 0; i < 4; i++) {
                int next_r = now.r + delta[i][0];
                int next_c = now.c + delta[i][1];

                if(next_r < 0 || next_r >= map.length || next_c < 0 || next_c >= map[0].length) continue;

                if(map[next_r][next_c] == 0 && !visit[next_r][next_c][wall]) {
                    visit[next_r][next_c][wall] = true;
                    distance[next_r][next_c] = distance[now.r][now.c] + 1;
                    queue.offer(new Point(next_r, next_c, wall));
                }
                else if(map[next_r][next_c] == 1 && wall == 0 && !visit[next_r][next_c][wall + 1]) {
                    visit[next_r][next_c][wall + 1] = true;
                    distance[next_r][next_c] = distance[now.r][now.c] + 1;
                    queue.offer(new Point(next_r, next_c, wall + 1));
                }

                if(next_r == map.length - 1 && next_c == map[0].length - 1) {
                    System.out.println(distance[map.length - 1][map[0].length - 1]);
                    return;
                }
            }
        }

        if(map.length == 1 && map[0].length == 1) System.out.println("1");
        else System.out.println("-1");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            char[] chArr = br.readLine().toCharArray();

            for(int j = 0; j < m; j++) {
                map[i][j] = chArr[j] - '0';
            }
        }

        bfs(map);

    }
}