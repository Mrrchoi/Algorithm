import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static ArrayList<Point> dot = new ArrayList<>();
    public static int[][] lab;
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int max = 0;
    public static int zero_count;

    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[lab.length][lab[0].length];
        int virus_count = 3;

        for(Point p : dot) {
            queue.offer(p);
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = now.x + delta[i][0];
                int nc = now.y + delta[i][1];

                if(nr < 0 || nr >= lab.length || nc < 0 || nc >= lab[0].length || lab[nr][nc] != 0 || visit[nr][nc]) continue;

                queue.offer(new Point(nr, nc));
                visit[nr][nc] = true;
                virus_count++;
            }
        }

        max = Math.max(max, zero_count - virus_count);
    }

    public static void combination(boolean[][] visit, int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < lab.length; i++) {
            for(int j = 0; j < lab[i].length; j++) {
                if(lab[i][j] == 0 && !visit[i][j]) {
                    lab[i][j] = 1;
                    visit[i][j] = true;
                    combination(visit, cnt + 1);
                    lab[i][j] = 0;
                    visit[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 0) zero_count++;
                else if(lab[i][j] == 2) dot.add(new Point(i, j));
            }
        }

        combination(new boolean[lab.length][lab[0].length], 0);

        bw.write(max + "");
        bw.close();
    }
}