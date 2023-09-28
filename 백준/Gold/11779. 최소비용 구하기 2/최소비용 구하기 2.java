import java.util.*;
import java.io.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void Dijkstra(ArrayList<Edge>[] graph, int start, int end) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        boolean[] visit = new boolean[graph.length];
        int[] distance = new int[graph.length];

        for(int i = 1; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            map.put(i, new ArrayList<>());
        }

        distance[start] = 0;

        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.v]) continue;

            visit[now.v] = true;

            ArrayList<Integer> list = map.get(now.v);

            list.add(now.v);

            map.put(now.v, list);

            for(Edge next : graph[now.v]) {
                if(!visit[next.v] && distance[next.v] > distance[now.v] + next.cost) {
                    distance[next.v] = distance[now.v] + next.cost;
                    pq.offer(new Edge(next.v, distance[next.v]));

                    ArrayList<Integer> copy = new ArrayList<>();
                    for(int value : map.get(now.v)) copy.add(value);
                    map.put(next.v, copy);
                }
            }
        }

        bw.write(distance[end] + "\n");
        bw.write(map.get(end).size() + "\n");
        for(int value : map.get(end)) {
            bw.write(value + " ");
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(graph, start, end);
    }
}