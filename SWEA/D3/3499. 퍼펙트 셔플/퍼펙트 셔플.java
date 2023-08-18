import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= test_case ; t++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();
            
            for(int i = 0; i < n / 2 + n % 2; i++) queue1.offer(st.nextToken());
            for(int i = n / 2 + n % 2; i < n; i++) queue2.offer(st.nextToken());
            
            bw.write("#" + t);
            while(!queue1.isEmpty() && !queue2.isEmpty()) bw.write(" " + queue1.poll() + " " + queue2.poll());
            
            if(!queue1.isEmpty())  bw.write(" " + queue1.poll());
            
            bw.newLine();
        }
        
        bw.close();
    }
}