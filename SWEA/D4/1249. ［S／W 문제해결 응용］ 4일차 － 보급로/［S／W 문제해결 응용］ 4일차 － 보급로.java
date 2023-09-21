import java.util.*;
import java.io.*;

public class Solution {
    public static class Node implements Comparable<Node> {
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static int Dijkstra(int[][] road) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] distance = new int[road.length][road.length];
        boolean[][] visit = new boolean[road.length][road.length];
        int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i < distance.length; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        distance[0][0] = 0;

        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(visit[now.r][now.c]) continue;

            visit[now.r][now.c] = true;

            for(int i = 0; i < 4; i++) {
                int nr = now.r + delta[i][0];
                int nc = now.c + delta[i][1];

                if(nr < 0 || nr >= distance.length || nc < 0 || nc >= distance.length || visit[nr][nc]) continue;

                if(distance[nr][nc] > distance[now.r][now.c] + road[nr][nc]) {
                    distance[nr][nc] = distance[now.r][now.c] + road[nr][nc];
                    pq.offer(new Node(nr, nc, distance[nr][nc]));
                }
            }
        }

        return distance[distance.length - 1][distance.length - 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] road = new int[n][n];

            for(int i = 0; i < n; i++) {
                char[] chArr = br.readLine().toCharArray();

                for(int j = 0; j < n; j++) {
                    road[i][j] = chArr[j] - '0';
                }
            }

            bw.write("#" +  t +  " " + Dijkstra(road) + "\n");
        }

        bw.close();
    }
}