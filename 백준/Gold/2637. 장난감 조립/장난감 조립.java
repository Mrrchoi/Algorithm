import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
        int y;
        int k;

        public Edge(int y, int k) {
            this.y = y;
            this.k = k;
        }
    }
    public static void topo_Sort(ArrayList<Edge>[] graph, int[] count) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Edge> queue = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] result = new int[count.length];

        for(int i = 1; i < count.length; i++) {
            if(count[i] == 0) {
                queue.add(new Edge(i, 1));
            }
        }

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            if(graph[now.y].size() == 0) {
                set.add(now.y);
                continue;
            }

            for(Edge next : graph[now.y]) {
                count[next.y]--;

                result[next.y] += now.k * next.k;

                if(count[next.y] == 0) {
                    queue.add(new Edge(next.y, result[next.y]));
                }
            }
        }

        for(int idx : set) {
            bw.write(idx + " " + result[idx] + "\n");
        }

        bw.close();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        int[] count = new int[n + 1];

        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph[x].add(new Edge(y, k));
            count[y]++;
        }

        topo_Sort(graph, count);
    }
}