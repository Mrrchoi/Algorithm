import java.util.*;
import java.io.*;

class Solution {
    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if(a < b) parent[b] = a;
        else if(a > b) parent[a] = b;
    }
    public static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }
    public static double kruskal(long[][] graph, int n) {
        int[] parent = new int[n];
        long total = 0;

        for(int i = 0; i < parent.length; i++) parent[i] = i;

        for(int i = 0; i < graph.length; i++) {
            if(find(parent, (int)graph[i][0]) != find(parent, (int)graph[i][1])) {
                total += graph[i][2];
                union(parent, (int)graph[i][0], (int)graph[i][1]);
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] dot = new int[n][2];
            long[][] graph = new long[n * (n -1) / 2][3];
            int idx = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                dot[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                dot[i][1] = Integer.parseInt(st.nextToken());
            }

            double e = Double.parseDouble(br.readLine());

            for(int i = 0; i < dot.length - 1; i++) {
                for(int j = i + 1; j < dot.length; j++) {
                    graph[idx][0] = i;
                    graph[idx][1] = j;
                    graph[idx][2] = (long)(Math.pow(dot[i][0] - dot[j][0], 2) + Math.pow(dot[i][1] - dot[j][1], 2));
                    idx++;
                }
            }

            Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2] >= 0 ? 1 : -1);

            bw.write("#" + t + " " + (long)(kruskal(graph, n) * e + 0.5) + "\n");
        }

        bw.close();
    }
}