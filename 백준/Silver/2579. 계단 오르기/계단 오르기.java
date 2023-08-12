import java.util.*;

class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) score[i] = sc.nextInt();

        dp[1] = score[1];
        if(n >= 2) dp[2] = score[1] + score[2];

        for(int i = 3; i <= n; i++) dp[i] = Math.max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i]);

        System.out.println(dp[n]);
    }
}