import java.util.*;
import java.io.*;

public class Main {
    public static boolean[] visit = new boolean[26];
    public static char[][] alpha;
    public static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int max = 0;

    public static void dfs(int r, int c, int count) {

        for(int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];

            if(nr < 0 || nr >= alpha.length || nc < 0 || nc >= alpha[0].length || visit[alpha[nr][nc] - 'A']) continue;

            visit[alpha[nr][nc] - 'A'] = true;
            dfs(nr, nc, count + 1);
            visit[alpha[nr][nc] - 'A'] = false;
        }

        max = Math.max(max, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        alpha = new char[r][c];

        for(int i = 0; i < r; i++) {
            alpha[i] = br.readLine().toCharArray();
        }

        visit[alpha[0][0] - 'A'] = true;

        dfs(0, 0, 1);

        bw.write(max + "");
        bw.close();
    }
}