import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case ; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Integer> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            int[] count = new int[n + m + 1];

            for(int i = 1; i <= n; i++) queue1.offer(i);
            for(int i = 1; i <= m; i++) queue2.offer(i);

            while(!queue1.isEmpty()){
                for(int i = 0; i < m; i++){
                    count[queue1.peek() + queue2.peek()]++;
                    queue2.offer(queue2.poll());
                }

                queue1.poll();
            }

            int max = 0;
            for(int i = 1; i < n + m + 1; i++) {
                if(max == count[i]) queue1.offer(i);
                else if(max < count[i]){
                    while(!queue1.isEmpty()) queue1.poll();

                    max = count[i];
                    queue1.offer(i);
                }
            }

            bw.write("#" + t);

            while(!queue1.isEmpty()) bw.write(" " + queue1.poll());

            bw.newLine();
        }

        bw.close();
    }
}