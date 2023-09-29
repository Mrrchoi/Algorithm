import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] wire = new int[501];
        int len = 0;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            wire[idx] = value;

            len = Math.max(len, idx);
        }

        int[] dp = new int[len + 1];

        for(int i = 1; i < dp.length; i++) {
            if(wire[i] == 0) continue;

            dp[i] = 1;

            for(int j = i - 1; j >= 1; j--) {
                if(wire[i] > wire[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;

        for(int i = 1; i < dp.length; i++) max = Math.max(max, dp[i]);

        bw.write((n - max) + "");
        bw.close();
    }
}