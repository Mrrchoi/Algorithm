import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static class Edge{
        int v;
        int cost;
        int max;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public Edge(int v, int cost, int max) {
            this.v = v;
            this.cost = cost;
            this.max = max;
        }
    }
    public static void bfs(ArrayList<Edge>[] graph, int n, int start, int end) {
        Queue<Edge> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        if(n == 1 || start == end) {
            System.out.println("0");
            return;
        }

        queue.add(new Edge(start, 0, 0));
        visit[start] = true;

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            for(Edge next : graph[now.v]) {
                if(!visit[next.v]) {
                    if(next.v == end) {
                        System.out.println(now.cost + next.cost - Math.max(now.max, next.cost));
                        return;
                    }

                    queue.add(new Edge(next.v, now.cost + next.cost, Math.max(now.max, next.cost)));
                    visit[next.v] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        bfs(graph, n, v, u);
    }
}