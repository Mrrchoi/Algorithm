class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle[triangle.length - 1].length][triangle[triangle.length - 1].length + 1];
        int answer = Integer.MIN_VALUE;
        
        dp[0][1] = triangle[0][0];
        
        for(int i = 1; i < triangle[triangle.length - 1].length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                dp[i][j + 1] = Math.max(dp[i - 1][j] + triangle[i][j], dp[i - 1][j + 1] + triangle[i][j]);
            }
        }
        
        for(int j = 1; j < dp.length; j++) {
            answer = Math.max(answer, dp[dp.length - 1][j]);
        }
        
        return answer;
    }
}