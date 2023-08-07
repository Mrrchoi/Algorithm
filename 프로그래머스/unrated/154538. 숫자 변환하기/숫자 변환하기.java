class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        
        for(int i = 0; i < x; i++) dp[i] = -1;
        
        for(int i = x + 1; i <= y; i++){
            int value = Integer.MAX_VALUE;
            if(i % 2 == 0 && dp[i / 2] != -1) value = Math.min(dp[i / 2] + 1, value);
            if(i % 3 == 0 && dp[i / 3] != -1) value = Math.min(dp[i / 3] + 1, value);
            if(i - n >= 0 && dp[i - n] != -1) value = Math.min(dp[i - n] + 1, value);
            
            if(value == Integer.MAX_VALUE) dp[i] = -1;
            else dp[i] = value;
        }
        
        return dp[y];
    }
}