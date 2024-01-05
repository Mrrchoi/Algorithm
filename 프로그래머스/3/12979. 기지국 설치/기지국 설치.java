import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;
        int index = 1;
        
        for(int station : stations) {
            if(index <= station - w - 1) {
                answer += Math.ceil((double)(station - w - index) / range);
            }
            
            index = station + w + 1;
        }
        
        if(index <= n) {
            answer += Math.ceil((double)(n - index + 1) / range);
        }
        
        return answer;
    }
}