import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int bfs(int[][] arr, boolean[][] visited, int m, int n, Point p) {
        Queue<Point> queue = new LinkedList<>();
        int area = 1;

        queue.add(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int[] d : delta) {
                Point next = new Point(now.x + d[0], now.y + d[1]);
                if(next.x < 0 || next.x >= n || next.y < 0 || next.y >= m || arr[next.x][next.y] != 0 || visited[next.x][next.y]) {
                    continue;
                }

                queue.add(next);
                visited[next.x][next.y] = true;
                area++;
            }
        }

        return area;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];

        for(int i = 0 ; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    arr[m - r - 1][c] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    result.add(bfs(arr, visited, n, m, new Point(i, j)));
                    count++;
                }
            }
        }

        result.sort(Comparator.naturalOrder());

        bw.write(count + "\n");

        for(int r : result) {
            bw.write(r + " ");
        }

        bw.close();
    }
}