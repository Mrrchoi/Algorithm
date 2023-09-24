import java.util.*;

public class Main {
    public static void bfs(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        int turn = 0, count = 0;
        
        if(n == k) {
            System.out.println("0");
            System.out.println("1");
            return;
        }

        queue.offer(n);

        while(!queue.isEmpty()){
            int len = queue.size();
            turn++;

            for(int i = 0; i < len; i++) {
                int v = queue.poll();

                if(v - 1 == k || v + 1 == k || v * 2 == k) {
                    count++;
                    continue;
                }

                if(v - 1 >= 0 && v - 1 <= 100000 && !visit[v - 1]){
                    queue.offer(v - 1);
                }
                if(v + 1 >= 0 && v + 1 <= 100000 && !visit[v + 1]){
                    queue.offer(v + 1);
                }
                if(v * 2 >= 0 && v * 2 <= 100000 && !visit[v * 2]){
                    queue.offer(v * 2);
                }
            }

            if(count != 0){
                System.out.println(turn);
                System.out.println(count);
                break;
            }

            for(int num : queue) visit[num] = true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        bfs(n, k);
    }
}