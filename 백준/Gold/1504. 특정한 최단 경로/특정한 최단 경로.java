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

    public static int Dijkstra(ArrayList<Edge>[] graph, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distance = new int[graph.length];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for(Edge next : graph[now.w]) {
                if(distance[next.w] > distance[now.w] + next.cost) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        for(int t = 0; t < e; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int distance = Dijkstra(graph, v1, v2);

        if(distance == Integer.MAX_VALUE) distance = -1;
        else {
            int dis1 = Dijkstra(graph, 1, v1);
            int dis2 = Dijkstra(graph, v2, n);
            int dis3 = Dijkstra(graph, 1, v2);
            int dis4 = Dijkstra(graph, v1, n);

            if(dis1 != Integer.MAX_VALUE && dis2 != Integer.MAX_VALUE) {
                dis1 += dis2;
            }
            else {
                dis1 = -1;
            }

            if(dis3 != Integer.MAX_VALUE && dis4 != Integer.MAX_VALUE) {
                dis3 += dis4;
            }
            else {
                dis3 = -1;
            }

            if(dis1 != -1 && dis3 != -1) distance += Math.min(dis1, dis3);
            else if(dis1 == -1 && dis3 != -1) distance += dis3;
            else if(dis1 != -1 && dis3 == -1) distance += dis1;
            else distance = -1;
        }

        bw.write(distance + "");
        bw.close();
    }
}