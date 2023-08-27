import java.util.*;

public class Main {
    public static void bfs(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[100001];

        queue.offer(n);

        while(!queue.isEmpty()){
            int v = queue.poll();
            
            if(v == k){
                System.out.println(visit[k]);
                break;
            }

            if(v - 1 >= 0 && v - 1 <= 100000 && visit[v - 1] == 0){
                visit[v - 1] = visit[v] + 1;
                queue.offer(v - 1);
            }
            if(v + 1 >= 0 && v + 1 <= 100000 && visit[v + 1] == 0){
                visit[v + 1] = visit[v] + 1;
                queue.offer(v + 1);
            }
            if(v * 2 >= 0 && v * 2 <= 100000 && visit[v * 2] == 0){
                visit[v * 2] = visit[v] + 1;
                queue.offer(v * 2);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        bfs(n, k);
    }
}