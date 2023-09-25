import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 1000000000;
    public static void Floyd(int[][] graph, int n) {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) System.out.print("0 ");
                else System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n + 1][n + 1];

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                if(i == j) continue;

                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        Floyd(graph, n);
    }
}