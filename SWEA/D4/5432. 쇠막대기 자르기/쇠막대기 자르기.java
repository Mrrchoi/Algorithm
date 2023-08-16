import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= test_case; t++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            int sum = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(i + 1 < s.length() && s.charAt(i) == '(' && s.charAt(i + 1) == ')'){
                    sum += stack.size();
                    i++;
                }
                else if(s.charAt(i) == '('){
                    stack.push(s.charAt(i));
                    sum++;
                }
                else stack.pop();
            }
            
            bw.write("#" + t + " " + sum + "\n");
            
        }
        
        bw.close();
    }
}