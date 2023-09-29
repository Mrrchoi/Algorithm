import java.io.*;
import java.util.*;

public class Main {
    public static int[] items;
    public static int INF = 1000000000;
    public static int max = 0;
    public static void Floyd(int[][] graph, int n, int m) {
        for (int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int total = 0;
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] != INF && graph[i][j] <= m) total += items[j];
            }

            max = Math.max(max, total);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;

                graph[i][j] = INF;
            }
        }

        items = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }

        Floyd(graph, n, m);

        bw.write(max + "");
        bw.close();
    }
}