import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] weight = new int[n + 1][2];
        int[][] dp = new int[n + 1][w + 1];


        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i][0] = Integer.parseInt(st.nextToken());
            weight[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < w + 1; j++) {
                if(j < weight[i][0]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], weight[i][1] + dp[i - 1][j - weight[i][0]]);
            }
        }

        bw.write(dp[n][w] + "");
        bw.close();

    }
}