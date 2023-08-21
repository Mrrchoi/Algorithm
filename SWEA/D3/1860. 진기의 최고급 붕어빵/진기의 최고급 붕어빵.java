import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        loop: for(int t = 1; t <= test_case; t++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < n; i++) queue.offer(sc.nextInt());

            int total = 0, count = 0;

            while(!queue.isEmpty()){
                int min = queue.poll();

                for(int i = 0; i < queue.size(); i++){
                    if(min > queue.peek()){
                        queue.offer(min);
                        min = queue.poll();
                    }
                    else queue.offer(queue.poll());
                }

                total = min / m * k;
                count++;

                if(total < count){
                    System.out.println("#" + t + " Impossible");
                    continue loop;
                }

            }

            System.out.println("#" + t + " Possible");
        }
    }
}