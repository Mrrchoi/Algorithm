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
    public static void kruskal(int[][] graph, int[] parent) {
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph.length; j++) {
                if(graph[i][j] == 0) continue;

                int x = find(parent, i);
                int y = find(parent, j);

                if(x != y) union(parent, Math.max(x, y), Math.min(x, y));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[][] graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            set.add(Integer.parseInt(st.nextToken()) - 1);
        }

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        kruskal(graph, parent);

        int root = -1;

        for(int num : set) {
            if(root == -1) root = find(parent, num);
            else if(find(parent, num) != root) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }
}