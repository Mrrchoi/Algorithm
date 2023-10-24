import java.util.*;

class Solution {
    public class Edge implements Comparable<Edge> {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public int Dijkstra(ArrayList<Edge>[] graph, int N, int K) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        int[] distance = new int[N + 1];
        int count = 0;
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        pq.add(new Edge(1, 0));
        distance[1] = 0;
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(visit[now.v]) continue;
            
            visit[now.v] = true;
            
            for(Edge next : graph[now.v]) {
                if(!visit[next.v] &&  distance[now.v] + next.cost < distance[next.v]) {
                    distance[next.v] = distance[now.v] + next.cost;
                    pq.add(new Edge(next.v, distance[next.v]));
                }
            }
        }
        
        for(int i = 1; i < N + 1; i++) {
            if(distance[i] <= K) count++;
        }
        
        return count;
    }
    public int solution(int N, int[][] road, int K) {
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        int answer = 0;

        for(int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < road.length; i++) {
            graph[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }
        

        return Dijkstra(graph, N, K);
    }
}