import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringBuffer sb = new StringBuffer();

            Stack<Character> stack = new Stack<>();
            
            for(char ch : s.toCharArray()){
                if(ch >= '0' && ch <= '9') sb.append(ch);
                else if(stack.empty()) stack.push(ch);
                else{
                    sb.append(stack.pop());
                    stack.push(ch);
                }
            }

            sb.append(stack.pop());

            Stack<Integer> cal = new Stack<>();

            for(char ch : sb.toString().toCharArray()){
                if(ch >= '0' && ch <= '9') cal.push(ch - '0');
                else cal.push(cal.pop() + cal.pop());
            }

            bw.write("#" + t + " " + cal.pop() + "\n");
        }

        bw.close();
    }
}