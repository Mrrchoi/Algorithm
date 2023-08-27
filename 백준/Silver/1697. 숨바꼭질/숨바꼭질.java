import java.util.*;
import java.io.*;

public class Main {
    public static void bfs(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[100001];

        queue.offer(n);

        while(!queue.isEmpty()){
            if(queue.contains(k)){
                System.out.println(visit[k]);
                break;
            }

            int v = queue.poll();
            int[] arr = {v - 1, v + 1, v * 2};

            for(int i = 0; i < 3; i++){
                if(arr[i] >= 0 && arr[i] <= 100000 && visit[arr[i]] == 0){
                    visit[arr[i]] = visit[v] + 1;
                    queue.offer(arr[i]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        bfs(n, k);
    }
}