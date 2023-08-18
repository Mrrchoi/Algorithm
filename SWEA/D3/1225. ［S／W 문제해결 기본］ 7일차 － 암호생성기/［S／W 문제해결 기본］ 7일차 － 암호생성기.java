import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int t = 0; t < 10 ; t++){
            int test_case = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < 8; i++) queue.offer(Integer.parseInt(st.nextToken()));
            
            int k = 1;
            
            while(true){
                int value = queue.poll() - k;
                
                if(value <= 0) {
                    queue.offer(0);
                    break;
                }
                
                queue.offer(value);
                
                k = k == 5 ? 1 : k + 1;
            }
            
            bw.write("#" + test_case);
            while(!queue.isEmpty()) bw.write(" " + queue.poll());
            bw.newLine();
        }
        
        bw.close();
    }
}