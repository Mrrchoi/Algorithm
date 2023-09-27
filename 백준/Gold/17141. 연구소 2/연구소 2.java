import java.util.*;
import java.io.*;
import java.awt.*;

public class Main {
    public static ArrayList<Point> dot = new ArrayList<>();
    public static int[][] lab;
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int min = Integer.MAX_VALUE;
    public static int count = 0;

    public static void bfs(boolean[] select) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[lab.length][lab.length];
        int bfs_count = -1, virus_count = 0;

        for(int i = 0; i < dot.size(); i++) {
            if(select[i]) {
                Point p = dot.get(i);
                queue.offer(p);
                visit[p.x][p.y] = true;
                virus_count++;
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();

            bfs_count++;

            for(int i = 0; i < len; i++) {
                Point now = queue.poll();

                for(int j = 0; j < 4; j++) {
                    int nr = now.x + delta[j][0];
                    int nc = now.y + delta[j][1];

                    if(nr < 0 || nr >= lab.length || nc < 0 || nc >= lab.length || lab[nr][nc] == 1 || visit[nr][nc]) continue;
                    queue.offer(new Point(nr, nc));
                    visit[nr][nc] = true;
                    virus_count++;
                }
            }
        }

        if(count == virus_count) {
            min = Math.min(min, bfs_count);
        }
    }

    public static void combination(boolean[] select, int m, int idx, int cnt) {
        if(cnt == m) {
            bfs(select);
            return;
        }
        else if(idx == select.length) return;

        select[idx] = true;
        combination(select, m, idx + 1, cnt + 1);
        select[idx] = false;
        combination(select, m, idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lab = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] != 1) count++;
                if(lab[i][j] == 2) dot.add(new Point(i, j));
            }
        }

        combination(new boolean[dot.size()], m, 0, 0);

        bw.write((min != Integer.MAX_VALUE ? min : -1) + "");
        bw.close();
    }
}