import java.util.*;
import java.io.*;

public class Main {
    public static List<Integer>[] graph;

    public static boolean bfs() {
        int[] visit = new int[graph.length];
        int[] value = {1, 2};

        for(int i = 1; i < graph.length; i++) {
            if(visit[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();

                queue.offer(i);
                visit[i] = 1;

                while (!queue.isEmpty()) {
                    int now = queue.poll();

                    for(int next : graph[now]) {
                        if(visit[next] == 0) {
                            queue.offer(next);
                            visit[next] = value[visit[now] % 2];
                        }
                        else if(visit[next] == visit[now]) return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for(int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];

            for(int i = 0; i < V + 1; i++) graph[i] = new ArrayList<>();

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            if(bfs()) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
    }
}