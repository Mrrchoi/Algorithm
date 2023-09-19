import java.util.*;
import java.io.*;
import java.awt.*;

class Solution {
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visit;

    public static void bfs(int[][] cheese, Point p, int x) {
        Queue<Point> queue = new LinkedList<>();
        int n = cheese.length;

        queue.offer(p);
        visit[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_r = now.x + delta[i][0];
                int next_c = now.y + delta[i][1];

                if(next_r < 0 || next_r >= n || next_c < 0 || next_c >= n || cheese[next_r][next_c] <= x || visit[next_r][next_c]) continue;

                queue.offer(new Point(next_r, next_c));
                visit[next_r][next_c] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cheese = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++) cheese[i][j] = Integer.parseInt(st.nextToken());
            }

            int max = 1;

            for(int x = 1; x <= 100; x++) {
                visit = new boolean[n][n];
                int cnt = 0;

                for(int r = 0; r < n; r++) {
                    for(int c = 0; c < n; c++) {
                        if(cheese[r][c] > x && !visit[r][c]) {
                            bfs(cheese, new Point(r, c), x);
                            cnt++;
                        }
                    }
                }

                max = max > cnt ? max : cnt;
            }

            bw.write("#" + t + " " + max +  "\n");
        }

        bw.close();
    }
}