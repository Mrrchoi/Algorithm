import java.util.*;

public class Main {
    public static int bfs(ArrayList<Integer>[] graph){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[graph.length];
        int count = 0;

        for(int i = 1; i < visit.length; i++){
            if(visit[i]) continue;

            queue.offer(i);
            visit[i] = true;
            count++;

            while(!queue.isEmpty()){
                int now = queue.poll();

                for(int v : graph[now]){
                    if(!visit[v]){
                        queue.offer(v);
                        visit[v] = true;
                    }
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        System.out.println(bfs(graph));
    }
}