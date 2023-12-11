import java.util.*;
import java.io.*;

public class Main {
    public static class Edge {
        int value;
        int clip;

        public Edge(int value, int clip) {
            this.value = value;
            this.clip = clip;
        }
    }
    public static int bfs(int s) {
        Queue<Edge> queue = new LinkedList<>();
        int[][] visit = new int[1001][1001];

        for(int i = 0; i <= 1000; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        visit[1][0] = 0;

        queue.add(new Edge(1, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if(now.value + now.clip <= 1000 && visit[now.value][now.clip] + 1 < visit[now.value + now.clip][now.clip]) {
                queue.add(new Edge(now.value + now.clip, now.clip));
                visit[now.value + now.clip][now.clip] = visit[now.value][now.clip] + 1;
            }

            if(now.value - 1 > 0 && visit[now.value][now.clip] + 1 < visit[now.value - 1][now.clip]) {
                queue.add(new Edge(now.value - 1, now.clip));
                visit[now.value - 1][now.clip] = visit[now.value][now.clip] + 1;
            }

            if(now.value != now.clip && visit[now.value][now.clip] + 1 < visit[now.value][now.value]) {
                queue.add(new Edge(now.value, now.value));
                visit[now.value][now.value] = visit[now.value][now.clip] + 1;
            }
        }

        int max = Integer.MAX_VALUE;

        for(int i = 0; i <= 1000; i++) {
            max = Math.min(max, visit[s][i]);
        }

        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s = Integer.parseInt(br.readLine());

        bw.write(bfs(s) + "");
        bw.close();
    }
}