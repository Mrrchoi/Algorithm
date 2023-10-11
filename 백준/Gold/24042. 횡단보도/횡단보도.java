import java.io.*;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int w;
        long cost;

        public Edge(int w, long cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    public static long Dijkstra(ArrayList<Edge>[] graph, int n, int m) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long[] distance = new long[n + 1];
        long INF = Long.MAX_VALUE;

        for(int i = 1; i <= n; i++) distance[i] = INF;

        distance[1] = 0;

        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(distance[now.w] < now.cost) continue;

            for(Edge next : graph[now.w]) {
                long new_cost = now.cost - (now.cost - next.cost) % m;

                if(new_cost <= now.cost) new_cost += m;

                if(new_cost < distance[next.w]) {
                    distance[next.w] = new_cost;
                    pq.add(new Edge(next.w, new_cost));
                }
            }
        }

        return distance[n];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, i + 1));
            graph[b].add(new Edge(a, i + 1));
        }

        bw.write(Dijkstra(graph, n, m) + "");
        bw.close();
    }
}