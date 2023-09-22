import java.util.*;
import java.io.*;

class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void topoSort(ArrayList<Integer>[] graph, int[] edgeCnt, int t) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < edgeCnt.length; i++) {
            if(edgeCnt[i] == 0) queue.offer(i);
        }

        bw.write("#" + t);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            bw.write(" " + now);

            for(int next : graph[now]) {
                edgeCnt[next]--;

                if(edgeCnt[next] == 0) queue.offer(next);
            }
        }

        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[v + 1];
            int[] edgeCnt = new int[v + 1];

            for(int i = 0; i < v + 1; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < e; i++){
                int u = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[u].add(w);

                edgeCnt[w]++;
            }

            topoSort(graph, edgeCnt, t);
        }

        bw.close();
    }
}