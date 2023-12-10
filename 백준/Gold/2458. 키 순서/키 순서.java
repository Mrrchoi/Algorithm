import java.util.*;
import java.io.*;

public class Main {
    public static int dfs_normal(boolean[][] graph, boolean[] visit, int n, int u) {
        int count = 0;

        visit[u] = true;

        for(int v = 1;  v < n + 1; v++) {
            if(graph[v][u] && !visit[v]) {
                count++;
                count += dfs_normal(graph, visit, n, v);
            }
        }

        return count;
    }
    public static int dfs_reverse(boolean[][] graph, boolean[] visit, int n, int u) {
        int count = 0;

        visit[u] = true;

        for(int v = 1;  v < n + 1; v++) {
            if(graph[u][v] && !visit[v]) {
                count++;
                count += dfs_reverse(graph, visit, n, v);
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n + 1][n + 1];
        int count = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
        }

        for(int i = 1; i < n + 1; i++) {
            int total = dfs_normal(graph, new boolean[n + 1], n, i) + dfs_reverse(graph, new boolean[n + 1], n, i) + 1;
            if(total == n) count++;
        }

        bw.write(count + "");
        bw.close();
    }
}