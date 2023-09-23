import java.util.*;

class Solution {
    public void bfs(int[][] computers, boolean[] visit, int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i = 0; i < computers.length; i++) {
                if(computers[now][i] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                bfs(computers, visit, i);
                answer++;
            }
        }

        return answer;
    }
}