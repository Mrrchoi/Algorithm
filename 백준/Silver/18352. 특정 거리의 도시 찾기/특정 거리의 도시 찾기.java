import java.io.*;
import java.util.*;

public class Main {
    public static void bfs(ArrayList<Integer>[] graph, int k, int x) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visit = new boolean[graph.length];
        int depth = 0;

        queue.add(x);
        visit[x] = true;

        while (!queue.isEmpty() && depth < k) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int now = queue.poll();

                for(int next: graph[now]) {
                    if(!visit[next]) {
                        visit[next] = true;
                        queue.add(next);
                    }
                }
            }

            depth++;
        }

        if(queue.isEmpty()) {
            sb.append("-1");
        }
        else {
            ArrayList<Integer> result = new ArrayList<>();
            
            while (!queue.isEmpty()) {
                result.add(queue.poll());
            }
            
            result.sort(Comparator.naturalOrder());
            
            for(int v : result) {
                sb.append(v + "\n");
            }
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        bfs(graph, k, x);
    }
}