import java.util.*;

class Solution {
    public int answer = 0;
    public void bfs(ArrayList<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[graph.length];
        int count = 0;
        
        queue.offer(1);
        visit[1] = true;
        
        while (!queue.isEmpty()) {
            int length = queue.size();
            count = 0;
            
            for(int i = 0; i < length; i++) {
                int now = queue.poll();
                
                for(int next : graph[now]) {
                    if(!visit[next]) {
                        queue.offer(next);
                        visit[next] = true;
                    }
                }
                
                count++;
            }
        }
        
        answer = count;
    }
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        bfs(graph);
        
        return answer;
    }
}