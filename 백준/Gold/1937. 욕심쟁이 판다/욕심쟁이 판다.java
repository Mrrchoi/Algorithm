import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int max = Integer.MIN_VALUE;
    public static int dfs(int[][] forest, int[][] visit, int N, Point now) {
        if(visit[now.x][now.y] != 0) {
            return visit[now.x][now.y];
        }

        for(int i = 0; i < delta.length; i++) {
            int nr = now.x + delta[i][0];
            int nc = now.y + delta[i][1];

            if(nr >= 0 && nr < N && nc >= 0 && nc < N && forest[nr][nc] > forest[now.x][now.y]) {
                visit[now.x][now.y] = Math.max(visit[now.x][now.y], dfs(forest, visit, N, new Point(nr, nc)));
            }
        }

        max = Math.max(max, ++visit[now.x][now.y]);

        return visit[now.x][now.y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] forest = new int[N][N];
        int[][] visit = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j] == 0) {
                    dfs(forest, visit, N, new Point(i, j));
                }
            }
        }

        bw.write(max + "");
        bw.close();
    }
}