import java.util.*;
import java.io.*;

public class Main {
    public static void union(int[] parent, int max, int min) {
        parent[max] = min;
    }
    public static int find(int[] parent, int x) {
        if(parent[x] != x) parent[x] = find(parent, parent[x]);

        return parent[x];
    }
    public static int kruskal(int[][] graph) {
        int[] parent = new int[graph.length];
        int total = 0;

        for(int i = 0; i < parent.length; i++) parent[i] = i;

        for(int i = 0; i < graph.length; i++) {
            int x = find(parent, graph[i][0]);
            int y = find(parent, graph[i][1]);
            if(x != y) {
                union(parent, Math.max(x, y), Math.min(x, y));
                total += graph[i][2];
            }
        }

        return total;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0) break;

            int[][] graph = new int[n][3];
            int total = 0;

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                total += graph[i][2] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

            bw.write((total - kruskal(graph)) + "\n");
        }

        bw.close();
    }
}