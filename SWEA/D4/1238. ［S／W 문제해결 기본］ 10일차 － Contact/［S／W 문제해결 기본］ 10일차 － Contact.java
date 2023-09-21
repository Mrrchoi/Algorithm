import java.util.*;
import java.io.*;

public class Solution {
    public static int bfs(ArrayList<Integer>[] graph, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[101];
        int last = 0;

        queue.offer(k);
        visit[k] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            last = 0;
            for(int i = 0; i < len; i++) {
                int now = queue.poll();

                last = Math.max(last, now);

                for(int next : graph[now]) {
                    if(!visit[next]) {
                        queue.offer(next);
                        visit[next] = true;
                    }
                }
            }
        }

        return last;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[101];

            for(int i = 0; i < 101; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n / 2; i++) {
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if(!graph[v].contains(w)) graph[v].add(w);
            }

            bw.write("#" + t + " " + bfs(graph, k) + "\n");
        }

        bw.close();
    }
}