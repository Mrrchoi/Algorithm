import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
        int w;
        int cost;

        public Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }
    }

    public static int max = 0;
    public static int w;

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visit, int v, int length) {
        visit[v] = true;

        if(max < length) {
            w = v;
            max = length;
        }

        for(Edge e : graph[v]) {
            if(!visit[e.w]) {
                dfs(graph, visit, e.w, length + e.cost);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println("0");
            System.exit(0);
        }

        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        dfs(graph, new boolean[n + 1], 1, 0);

        max = 0;

        dfs(graph, new boolean[n + 1], w, 0);

        bw.write(max + "");
        bw.close();
    }
}