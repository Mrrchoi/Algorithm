import java.util.*;
import java.io.*;

public class Main {
    public static int[] bfs(ArrayList<int[]>[] graph, int n, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] visit = new int[n + 1];
        int[] result = new int[2];

        Arrays.fill(visit, Integer.MAX_VALUE);

        pq.add(new int[]{c, 0});
        visit[c] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if(now[1] > visit[now[0]]) continue;

            result[0]++;
            result[1] = Math.max(result[1], now[1]);

            for(int[] next : graph[now[0]]) {
                if (next[1] + visit[now[0]] < visit[next[0]]) {
                    visit[next[0]] = visit[now[0]] + next[1];
                    pq.add(new int[]{next[0], visit[next[0]]});
                }
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ArrayList<int[]>[] graph = new ArrayList[n + 1];

            for(int i = 1; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new int[]{a, s});
            }

            int[] result = bfs(graph, n, c);

            bw.write(result[0] + " " + result[1] + "\n");
        }

        bw.close();
    }
}