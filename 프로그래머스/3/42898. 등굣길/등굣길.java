class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        
        dp[0][1] = 1;
        
        for(int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(dp[i][j] == -1) continue;
                
                int total = 0;
                
                if(dp[i - 1][j] != -1) total += dp[i - 1][j];
                if(dp[i][j - 1] != -1) total += dp[i][j - 1];
                
                dp[i][j] = total % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}