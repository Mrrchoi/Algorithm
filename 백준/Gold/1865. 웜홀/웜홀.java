import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }

    public static boolean Bellman_Ford(ArrayList<Edge> graph, int n) {
        int[] distance = new int[n + 1];
        int INF = 100001;
        boolean check = false;

        for(int i = 1; i < distance.length; i++) distance[i] = INF;

        distance[1] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph.size(); j++) {
                Edge edge = graph.get(j);

                if(distance[edge.w] > distance[edge.v] + edge.cost) {
                    distance[edge.w] = distance[edge.v] + edge.cost;
                }

            }
        }

        for(int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);

            if(distance[edge.w] > distance[edge.v] + edge.cost) {
                check = true;
            }
        }

        return check;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            ArrayList<Edge> graph = new ArrayList<>();

            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.add(new Edge(s, e, t));
                graph.add(new Edge(e, s, t));
            }

            for(int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.add(new Edge(s, e, -t));
            }

            if(Bellman_Ford(graph, n)) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
    }
}