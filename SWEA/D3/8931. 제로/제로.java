import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= t; i++) {
            Stack<Integer> stack = new Stack<>();
            int n = Integer.parseInt(br.readLine());
            
            for(int j = 0; j < n; j++){
                int k = Integer.parseInt(br.readLine());
                
                if(k != 0) stack.push(k);
                else stack.pop();
            }
            
            int sum = 0;
            
            for(int k : stack) sum += k;
            
            bw.write("#" + i + " " + sum + "\n");
        }
        
        bw.close();
    }
}