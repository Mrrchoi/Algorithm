class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        int size = 0;
        int left_i = (int)(left / n), left_j = (int)(left % n);
        int right_i = (int)(right / n), right_j = (int)(right % n);
        
        if(left_i == right_i) size = right_j - left_j + 1;
        else size += (n - left_j) + (right_j + 1) + n * (right_i - left_i - 1);
        
        answer = new int[size];
        
        for(int i = left_i, idx = 0; i <= right_i; i++){
            int count = 0;
            int k = i + 1;
            
            for(int j = 0; j < n; j++){
                if(count == i + 1) k++;
                else count++;
                
                if(i == left_i && j < left_j) continue;
                if(i == right_i && j > right_j) break;
                
                answer[idx++] = k;
            }
        }
        
        return answer;
    }
}