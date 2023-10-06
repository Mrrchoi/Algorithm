import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {1, 1}};
    public static int count = 0;
    public static void dfs(int[][] arr, boolean[][] visit, Point now, int type) {
        if(now.x == arr.length - 1 && now.y == arr.length - 1) {
            count++;
            return;
        }

        visit[now.x][now.y] = true;

        int s = 0, w = 1;

        if(type == 0) {
            w = 2;
        }
        else if(type == 1) {
            s = 1;
        }

        for(int i = s; i < 3; i += w) {
            int nr = now.x + delta[i][0];
            int nc = now.y + delta[i][1];

            if(nr < 0 || nr >= arr.length || nc < 0 || nc >= arr.length || arr[nr][nc] == 1 || (i == 2 && (arr[nr - 1][nc] == 1 || arr[nr][nc - 1] == 1)) || visit[nr][nc]) continue;

            dfs(arr, visit, new Point(nr, nc), i);
            visit[nr][nc] = false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr, new boolean[n][n], new Point(0, 1), 0);

        bw.write(count + "");
        bw.close();
    }
}