import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int dfs(int[][] map, int[][] visit, int n, int m, Point now) {
        if(visit[now.x][now.y] >= 0 || (now.x == n - 1 && now.y == m - 1)) {
            return visit[now.x][now.y];
        }

        visit[now.x][now.y] = 0;

        for(int i = 0; i < delta.length; i++) {
            int nr = now.x + delta[i][0];
            int nc = now.y + delta[i][1];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] < map[now.x][now.y]) {
                visit[now.x][now.y] += dfs(map, visit, n, m, new Point(nr, nc));
            }
        }

        return visit[now.x][now.y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] visit = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }

        visit[n - 1][m - 1] = 1;

        bw.write(dfs(map, visit, n, m, new Point(0, 0)) +  "");
        bw.close();
    }
}