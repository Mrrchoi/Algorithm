import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        for(int i = 0; i < n; i++) {
            int num = pq.poll();
            
            if(num == 0) {
                return 0;
            }
            
            pq.add(num - 1);
        }
        
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}