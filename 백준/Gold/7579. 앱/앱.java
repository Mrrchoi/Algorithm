import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] memory = new int[n + 1][2];
        int[][] dp = new int[n + 1][10001];

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < n + 1; j++) {
                memory[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < 10001; j++) {
                if(j < memory[i][1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - memory[i][1]] + memory[i][0]);
            }
        }

        for(int i = 0; i < 10001; i++) {
            if(dp[n][i] >= m) {
                bw.write(i + "");
                break;
            }
        }

        bw.close();
    }
}