class Solution {
    public int idx = 0;
    public void Hanoi(int[][] answer, int n, int start, int mid, int to) {
        if(n == 1) {
            answer[idx][0] = start;
            answer[idx++][1] = to;
            return;
        }
        
        Hanoi(answer, n - 1, start, to, mid);
        
        answer[idx][0] = start;
        answer[idx++][1] = to;
        
        Hanoi(answer, n - 1, mid, start, to);
    }
    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2, n) - 1][2];
        
        Hanoi(answer, n, 1, 2, 3);
        
        return answer;
    }
}