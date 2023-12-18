import java.util.*;
import java.io.*;

public class Main {
    public static void getPath(ArrayList<Integer> list, int[][] path, int start, int end) {
        if (path[start][end] == 0) {
            list.add(end);
            return;
        }
        getPath(list, path, start, path[start][end]);
        getPath(list, path, path[start][end], end);
    }
    public static void floyd(int[][] graph, int n) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] path = new int[n + 1][n + 1];
        int INF = 1000000000;

        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                if(k == i) continue;
                for(int j = 1; j < n + 1; j++) {
                    if (k == j || i == j) continue;

                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                bw.write((graph[i][j] != INF ? graph[i][j] : 0) + " ");
            }

            bw.newLine();
        }

        for(int i = 1; i < n + 1; i ++) {
            for(int j = 1; j < n + 1; j++) {
                if(graph[i][j] == INF) bw.write("0\n");
                else {
                    ArrayList<Integer> list = new ArrayList<>();

                    list.add(i);

                    getPath(list, path, i, j);

                    bw.write(list.size() + " ");

                    for(int p : list) {
                        bw.write(p + " ");
                    }

                    bw.newLine();
                }
            }
        }

        bw.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        int INF = 1000000000;

        for(int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        floyd(graph, n);
    }
}