import java.util.*;
import java.io.*;

public class Main {
    public static void bfs(int[] graph){
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[101];

        queue.offer(1);

        loop: while (!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 1; i <= 6; i++){
                int next = graph[now + i];

                if(visit[next] == 0){
                    visit[next] = visit[now] + 1;
                    queue.add(next);
                }

                if(next == 100) break loop;
            }
        }

        System.out.println(visit[100]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] graph = new int[101];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 101; i++) graph[i] = i;

        for(int i = 0; i < n + m; i++){
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs(graph);
    }
}
