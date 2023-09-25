import java.io.*;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int v;
        int w;
        long cost;

        public Edge (int v, int w, long cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost >= o.cost ? 1 : -1;
        }
    }

    public static void BellmanFord(ArrayList<Edge> graph, int n, int m, int start) {
        long[] distance = new long[n + 1];

        Arrays.fill(distance, Long.MAX_VALUE);
        distance[start] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Edge now = graph.get(j);

                if(distance[now.v] != Long.MAX_VALUE && distance[now.w] > distance[now.v] + now.cost) {
                    distance[now.w] = distance[now.v] + now.cost;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            Edge now = graph.get(i);

            if(distance[now.v] != Long.MAX_VALUE && distance[now.w] > distance[now.v] + now.cost) {
                System.out.println("-1");
                return;
            }
        }

        for(int i = 2; i <= n; i++) {
            if(distance[i] == Long.MAX_VALUE) System.out.println("-1");
            else System.out.println(distance[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Edge> graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a, b, c));
        }

        BellmanFord(graph, n, m, 1);
    }
}