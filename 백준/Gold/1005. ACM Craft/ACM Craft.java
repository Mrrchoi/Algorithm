import java.io.*;
import java.util.*;

public class Main {
    public static int topo_Sort(ArrayList<Integer>[] graph, int[] time, int[] count, int w) {
        Queue<Integer> queue = new LinkedList<>();
        int[] sum = new int[time.length];

        for(int i = 1; i < count.length; i++) {
            if(count[i] == 0) {
                queue.offer(i);
                sum[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : graph[now]) {
                sum[next] = Math.max(sum[next], sum[now]);

                if(--count[next] == 0) {
                    sum[next] += time[next];

                    if(next == w) return sum[next];

                    queue.offer(next);
                }
            }
        }

        return sum[w];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < t; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            int[] time = new int[n + 1];
            int[] count = new int[n + 1];

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);

                count[y]++;
            }

            int w = Integer.parseInt(br.readLine());

            bw.write(topo_Sort(graph, time, count, w) + "\n");
        }

        bw.close();
    }
}