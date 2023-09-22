import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static int bfs(int n, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.y - o2.y);
        boolean[] visit = new boolean[100001];
        int[] result = new int[100001];

        Arrays.fill(result, Integer.MAX_VALUE);

        pq.add(new Point(n, 0));
        result[n] = 0;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if(now.x == k) return result[k];

            if(visit[now.x]) continue;

            visit[n] = true;

            if(now.x * 2 <= 100000 && !visit[now.x * 2] && result[now.x * 2] > result[now.x]) {
                result[now.x * 2] = result[now.x];
                pq.offer(new Point(now.x * 2, result[now.x * 2]));
            }

            if(now.x + 1 <= 100000 && !visit[now.x + 1] && result[now.x + 1] > result[now.x] + 1) {
                result[now.x + 1] = result[now.x] + 1;
                pq.offer(new Point(now.x + 1, result[now.x + 1]));
            }

            if(now.x - 1 >= 0 && !visit[now.x - 1] && result[now.x - 1] > result[now.x] + 1) {
                result[now.x - 1] = result[now.x] + 1;
                pq.offer(new Point(now.x - 1, result[now.x - 1]));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(bfs(n, k) + "");
        bw.close();
    }
}