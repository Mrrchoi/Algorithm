import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0, right = 0;
        
        for (int stone : stones) {
            right = Math.max(stone, right);
        }
        
        loop: while (left <= right) {
            int mid = (left + right) / 2;
            
            int count = 0;
            
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid < 0) {
                    count++;
                    
                    if (count == k) {
                        right = mid - 1;
                        continue loop;
                    }
                }
                else {
                    count = 0;
                }
            }
            
            left = mid + 1;
        }
        
        return right;
    }
}