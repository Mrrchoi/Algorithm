import java.util.*;

class Solution {
    public int[] bfs(ArrayList<Integer>[] graph, int n, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : graph[now]) {
                if(distance[next] == 0 && next != start) {
                    queue.add(next);
                    distance[next] = distance[now] + 1;
                }
            }
        }
        
        for(int i = 1; i < n + 1; i++) {
            if(distance[i] == 0 && i != start) {
                distance[i] = -1;
            }
        }
        
        return distance;
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] answer = new int[sources.length];
        
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        int[] distance = bfs(graph, n, destination);
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
}