import java.io.*;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int w;
        int cost;

        public Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static final int INF = Integer.MAX_VALUE;

    public static int Dijkstra(ArrayList<Edge>[] graph, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distance = new int[graph.length];
        boolean[] visit = new boolean[graph.length];

        for(int i = 1; i < distance.length; i++) distance[i] = INF;

        distance[start] = 0;

        pq.offer(new Edge(start, distance[start]));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.w]) continue;

            visit[now.w] = true;

            for(Edge next : graph[now.w]) {
                if(!visit[next.w] && distance[next.w] > distance[now.w] + next.cost) {
                    distance[next.w] = distance[now.w] + next.cost;
                    pq.offer(new Edge(next.w, distance[next.w]));
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bw.write(Dijkstra(graph, start, end) + "");
        bw.close();
    }
}