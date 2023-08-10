import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1; i <= n; i++) queue.offer(i);

        System.out.print("<");

        while(queue.size() != 0){
            for(int i = 1; i < k; i++) queue.offer(queue.poll());

            System.out.print(queue.poll());

            if(queue.size() != 0) System.out.print(", ");
        }

        System.out.print(">");
    }
}