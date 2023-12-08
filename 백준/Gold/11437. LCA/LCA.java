import java.util.*;
import java.io.*;

public class Main {
    public static void dfs(ArrayList<Integer>[] graph, int[] parent, int[] depth, int v) {
        for(int w : graph[v]) {
            if(depth[w] == -1) {
                depth[w] = depth[v] + 1;
                parent[w] = v;
                dfs(graph, parent, depth, w);
            }
        }
    }
    public static int lca(int[] parent, int[] depth, int v, int w) {
        while (v != w) {
            if(depth[v] > depth[w]) {
                v = parent[v];
            }
            else if(depth[v] < depth[w]) {
                w = parent[w];
            }
            else {
                v = parent[v];
                w = parent[w];
            }
        }

        return v;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] parent = new int[n + 1];
        int[] depth = new int[n + 1];

        for(int i = 1; i< n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[v].add(w);
            graph[w].add(v);
        }

        Arrays.fill(depth, -1);

        depth[1] = 0;

        dfs(graph, parent, depth, 1);

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            bw.write(lca(parent, depth, v, w) + "\n");
        }

        bw.close();
    }
}