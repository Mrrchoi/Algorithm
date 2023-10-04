class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int total = sequence[0], l = 0, r = 0;
        
        while(l <= r && l < sequence.length && r < sequence.length) {
            if(total == k) {
                if(answer[1] - answer[0] > r - l) {
                    answer[0] = l;
                    answer[1] = r;
                }
                
                if(r == sequence.length - 1) break;
                total += sequence[++r];
            }
            else if(total < k) {
                if(r == sequence.length - 1) break;
                total += sequence[++r];
            }
            else {
                total -= sequence[l++];
            }
        }
        
        return answer;
    }
}