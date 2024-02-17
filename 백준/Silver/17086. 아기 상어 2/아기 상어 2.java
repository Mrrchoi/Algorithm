import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    public static int max = 0;
    public static int[][] delta = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1} , {0, -1}, {-1, -1}};

    public static void bfs(int[][] arr, Point p) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        int depth = 1;

        visit[p.x][p.y] = true;
        queue.add(p);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                Point now = queue.poll();

                for(int j = 0; j < delta.length; j++) {
                    Point next = new Point(now.x + delta[j][0], now.y + delta[j][1]);

                    if(next.x < 0 || next.x >= arr.length || next.y < 0 || next.y >= arr[0].length || visit[next.x][next.y]) {
                        continue;
                    }

                    if(arr[next.x][next.y] == 1) {
                        max = Math.max(max, depth);
                        return;
                    }

                    queue.add(next);
                    visit[next.x][next.y] = true;
                }
            }

            depth++;
        }

        max = depth - 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != 1) {
                    bfs(arr, new Point(i, j));
                }
            }
        }

        bw.write(max + "");
        bw.close();
    }
}