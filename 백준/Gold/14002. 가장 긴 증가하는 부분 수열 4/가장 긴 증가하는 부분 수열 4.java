import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = 1;

            for(int j = i - 1; j >= 1; j--) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int len = 1;

        for(int i = 1; i <= n; i++) len = Math.max(len, dp[i]);

        bw.write(len + "\n");

        for(int i = n; i >= 1; i--) {
            if(dp[i] == len) {
                stack.push(arr[i]);
                len--;
            }
        }

        while (!stack.isEmpty()) {
            bw.write( stack.pop() + " ");
        }

        bw.close();
    }
}