import java.util.*;
import java.io.*;

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
            return this.cost - o.cost;
        }
    }

    public static int[] Dijkstra(ArrayList<Edge>[] graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distance = new int[graph.length];
        boolean[] visit = new boolean[graph.length];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.w]) continue;

            visit[now.w] = true;

            for (Edge next : graph[now.w]) {
                if(!visit[next.w] && distance[next.w] > distance[now.w] + next.cost) {
                    distance[next.w] = distance[now.w] + next.cost;
                    pq.offer(new Edge(next.w, distance[next.w]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[v + 1];
        int[][] distance = new int[v + 1][v + 1];

        for(int i = 1; i < v + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        for(int i = 1; i <= v; i++) {
            distance[i] = Dijkstra(graph, i);
        }

        int min_distance = Integer.MAX_VALUE;

        for(int i = 1; i < v; i++) {
            for(int j = i + 1; j < v + 1; j++) {
                if(distance[i][j] == Integer.MAX_VALUE || distance[j][i] == Integer.MAX_VALUE) continue;

                min_distance = Math.min(min_distance, distance[i][j] + distance[j][i]);
            }
        }

        bw.write((min_distance != Integer.MAX_VALUE ? min_distance : -1) + "");
        bw.close();
    }
}