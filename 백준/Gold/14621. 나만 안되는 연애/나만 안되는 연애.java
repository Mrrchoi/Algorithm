import java.util.*;
import java.io.*;

public class Main {
    public static class Edge implements Comparable<Edge>{
        int v;
        int d;

        public Edge(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.d, o.d);
        }
    }
    public static int prim(ArrayList<Edge>[] graph, int[] gender, int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N + 1];
        int total = 0, count = 0;

        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.v]) continue;

            visit[now.v] = true;
            total += now.d;

            if(++count == N) {
                return total;
            }

            for(Edge next : graph[now.v]) {
                if(!visit[next.v] && gender[now.v] != gender[next.v]) {
                    pq.add(next);
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        int[] gender = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++) {
            if(st.nextToken().equals("W")) {
                gender[i] = 1;
            }

            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, d));
            graph[v].add(new Edge(u, d));
        }

        bw.write(prim(graph, gender, N) + "");
        bw.close();
    }
}