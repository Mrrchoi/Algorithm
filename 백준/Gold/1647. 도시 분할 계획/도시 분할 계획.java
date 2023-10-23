import java.io.*;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int v;
        int w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void union(int[] parent, int x, int y) {
        if(x > y) parent[x] = y;
        else parent[y] = x;
    }
    public static int find(int[] parent, int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent, parent[x]);
    }
    public static long kruskal(ArrayList<Edge> graph, int n) {
        int[] parent = new int[n + 1];
        long count = 0, total_cost = 0;

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < graph.size(); i++) {
            if(count == n - 2) break;

            Edge now = graph.get(i);
            int px = find(parent, now.v);
            int py = find(parent, now.w);

            if(px != py) {
                union(parent, px, py);
                total_cost += now.cost;
                count++;
            }
        }

        return total_cost;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge> graph = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a, b, c));
        }

        Collections.sort(graph);

        bw.write(kruskal(graph, n) + "");
        bw.close();
    }
}