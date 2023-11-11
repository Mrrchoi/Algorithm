import java.io.*;
import java.util.*;

public class Main {
    public static void topo_sort(ArrayList<Integer>[] graph, int[] time, int[] count) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        int[] cost = new int[time.length];

        for(int i = 1; i < count.length; i++) {
            if(count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            cost[now] += time[now];

            for(int next : graph[now]) {
                cost[next] = Math.max(cost[next], cost[now]);
                if(--count[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for(int i = 1; i < cost.length; i++) {
            bw.write(cost[i] + "\n");
        }

        bw.close();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] time = new int[n + 1];
        int[] count = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int k = Integer.parseInt(st.nextToken());

                if(k == -1) break;

                graph[k].add(i);
                count[i]++;
            }
        }

        topo_sort(graph, time, count);
    }
}