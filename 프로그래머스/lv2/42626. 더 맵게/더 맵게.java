import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
		
		for(int i : scoville) pq.add(i);
		
		while(true) {
            if(pq.peek() >= K) break;
            else if(pq.size() == 1){
                answer = -1;
                break;
            }
            
			pq.add(pq.poll() + pq.poll() * 2);
			
			answer++;
		}
        
        return answer;
    }
}