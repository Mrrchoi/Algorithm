import java.io.*;
import java.util.*;

public class Main {
    public static int bfs(ArrayList<Integer>[] graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[graph.length];
        int count = 0, sum = 0;

        queue.offer(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int len = queue.size();
            count++;

            for(int i = 0; i < len; i++){
                int now = queue.poll();

                for(int v : graph[now]){
                    if(!visit[v]){
                        queue.offer(v);
                        visit[v] = true;
                        sum += count;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int min = Integer.MAX_VALUE, idx = 0;

        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for(int i = 1; i <= n; i++){
            int value = bfs(graph, i);

            if(min > value) {
                min = value;
                idx = i;
            }
        }

        bw.write(idx + "");
        bw.close();
    }
}