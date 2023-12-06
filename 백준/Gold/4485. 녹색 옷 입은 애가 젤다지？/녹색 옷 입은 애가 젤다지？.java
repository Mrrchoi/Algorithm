import java.util.*;
import java.io.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int r;
        int c;
        int cost;

        public Edge(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1},{-1, 0}};
    public static int Dijkstra(int[][] cave, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];
        int[][] cost = new int[n][n];
        int INF = 1000000000;

        for(int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
        }

        cost[0][0] = cave[0][0];
        pq.add(new Edge(0, 0, cost[0][0]));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.r][now.c]) continue;
            else if(now.r == n - 1 && now.c == n - 1) break;

            visit[now.r][now.c] = true;

            for(int[] d : delta) {
                int nr = now.r + d[0];
                int nc = now.c + d[1];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc] || cost[nr][nc] < now.cost + cave[nr][nc]) {
                    continue;
                }

                cost[nr][nc] = now.cost +  cave[nr][nc];

                pq.add(new Edge(nr, nc, cost[nr][nc]));
            }
        }

        return cost[n - 1][n - 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test = 1;

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            int[][] cave = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("Problem " + (test++) + ": " + Dijkstra(cave, n) + "\n");
        }

        bw.close();
    }
}