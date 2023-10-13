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
    public static int[] Dijkstra(ArrayList<Edge>[] graph, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue();
        boolean[] visit = new boolean[graph.length];
        int[] distance = new int[graph.length];
        int INF = Integer.MAX_VALUE;

        for(int i = 1; i < distance.length; i++) distance[i] = INF;

        distance[start] = 0;

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.w]) continue;

            visit[now.w] = true;

            for(Edge next : graph[now.w]) {
                if (!visit[next.w] && now.cost + next.cost < distance[next.w]) {
                    distance[next.w] = now.cost + next.cost;
                    pq.add(new Edge(next.w, distance[next.w]));
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            ArrayList<Edge>[] graph = new ArrayList[n + 1];
            TreeSet<Integer> set = new TreeSet<>();
            int[] candidate = new int[t];

            for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Edge(b, d));
                graph[b].add(new Edge(a, d));
            }

            int[] distance1 = Dijkstra(graph, s);
            int[] distance2 = Dijkstra(graph, g);

            for(int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                int[] distance3 = Dijkstra(graph, x);

                if(Math.min(distance1[g] + distance2[h] + distance3[h], distance1[h] + distance2[h] + distance3[g]) == distance1[x]) set.add(x);
            }

            for(int answer : set) bw.write(answer + " ");
            bw.newLine();
        }

        bw.close();
    }
}