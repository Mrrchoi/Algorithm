class Solution {
    public int solution(String[][] board, int h, int w) {
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = board.length;
        int answer = 0;
        
        for(int[] d : delta) {
            int nh = h + d[0];
            int nw = w + d[1];
            
            if(nh >= 0 && nh < n && nw >= 0 && nw < n && board[h][w].equals(board[nh][nw])) {
                answer++;
            }
        }
        
        return answer;
    }
}