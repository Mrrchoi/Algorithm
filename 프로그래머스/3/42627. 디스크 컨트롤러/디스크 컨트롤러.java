import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int answer = 0, time = 0, idx = 0, count = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);      
        
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
            }
            else {
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
                count++;
            }
        }
        
        return answer / jobs.length;
    }
}