import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int v;
        double cost;

        public Edge(int v, double cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.cost >= o.cost) return 1;
            else return -1;
        }
    }

    public static void prim(ArrayList<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[graph.length];
        double total = 0;

        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.v]) continue;

            visit[now.v] = true;
            total += now.cost;

            for(Edge e : graph[now.v]) {
                if(!visit[e.v]) {
                    pq.offer(e);
                }
            }
        }

        System.out.printf("%.2f", total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[n];
        double[][] dot = new double[n][2];

        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Double.parseDouble(st.nextToken());
            dot[i][1] = Double.parseDouble(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                graph[i].add(new Edge(j, Math.sqrt(Math.pow(dot[i][0] - dot[j][0], 2) + Math.pow(dot[i][1] - dot[j][1], 2))));
            }
        }

        prim(graph);
    }
}