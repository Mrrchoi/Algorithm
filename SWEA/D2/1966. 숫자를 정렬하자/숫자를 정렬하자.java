import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int t = 1; t <= test_case; t++){
            int n = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) queue.offer(sc.nextInt());

            System.out.print("#" + t);

            while(!queue.isEmpty()){
                int min = queue.poll();

                for(int i = 0; i < queue.size(); i++){
                    if(min > queue.peek()){
                        queue.offer(min);
                        min = queue.poll();
                    }
                    else queue.offer(queue.poll());
                }

                System.out.print(" " + min);
            }

            System.out.println();
        }
    }
}