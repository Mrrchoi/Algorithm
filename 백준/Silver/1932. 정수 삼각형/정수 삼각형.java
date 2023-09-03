import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = Integer.parseInt(br.readLine());

        for(int i = 2; i < n + 1; i++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[i + 1];

            for(int j = 1; j < i + 1; j++) arr[j] = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= i; j++) arr[j] += Math.max(dp[j - 1], dp[j]);

            for(int j = 1; j <= i; j++) dp[j] = arr[j];
        }

        int max = 0;

        for(int i = 1; i < n + 1; i++) max = max > dp[i] ? max : dp[i];

        bw.write(max + "");
        bw.close();
    }
}