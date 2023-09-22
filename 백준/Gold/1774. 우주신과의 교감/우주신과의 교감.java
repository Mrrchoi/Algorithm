import java.util.*;
import java.io.*;

public class Main {
    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    public static int find(int[] parent, int x) {
        if(parent[x] != x) parent[x] = find(parent, parent[x]);

        return parent[x];
    }
    public static double kruskal(long[][] graph, int[] parent) {
        double total = 0;

        for(int i = 0; i < graph.length; i++) {
            int x = find(parent, (int)graph[i][0]);
            int y = find(parent, (int)graph[i][1]);
            if(x != y) {
                union(parent, x, y);
                total += Math.sqrt(graph[i][2]);
            }
        }

        return total;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] graph = new long[n * (n - 1) / 2][3];
        int[][] dot = new int[n + 1][2];
        int[] parent = new int[n + 1];

        for(int i = 0; i < n + 1; i++) parent[i] = i;

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1, idx = 0; i < n; i++) {
            for(int j = i + 1; j < n + 1; j++) {
                graph[idx][0] = i;
                graph[idx][1] = j;
                graph[idx][2] = (long)(Math.pow(dot[i][0] - dot[j][0], 2) + Math.pow(dot[i][1] - dot[j][1], 2));
                idx++;
            }
        }

        Arrays.sort(graph, (o1, o2) -> o1[2] >= o2[2] ? 1 : -1);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(parent, a, b);
        }

        System.out.printf("%.2f", kruskal(graph, parent));
        bw.close();
    }
}