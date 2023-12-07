import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int bfs(int[][] board, int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> cheese = new ArrayList<>();
        boolean[][] visit = new boolean[n][m];

        queue.add(new Point(0, 0));

        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int[] d : delta) {
                int nr = now.x + d[0];
                int nc = now.y + d[1];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc]) continue;
                else if(board[nr][nc] == 0) {
                    queue.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                }
                else if(board[nr][nc] == 1) {
                    cheese.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                }
            }
        }

        for(Point tmp : cheese) {
            board[tmp.x][tmp.y] = 0;
        }

        return cheese.size();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int count = 0, last = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int total = bfs(board, n, m);

            if (total == 0) break;

            last = total;
            count++;
        }

        bw.write(count + "\n" + last);
        bw.close();
    }
}