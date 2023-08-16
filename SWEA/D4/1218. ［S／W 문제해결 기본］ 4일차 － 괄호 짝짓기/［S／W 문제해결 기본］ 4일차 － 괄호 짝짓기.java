import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Character> map = new HashMap<Character, Character>(){{
          put(')', '('); put('>','<'); put(']', '['); put('}','{');
        }};
        String open = "(<{[";
        
        loop: for(int t = 1; t <= 10; t++) {
            Stack<Character> stack = new Stack<>();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            
            for (char ch : s.toCharArray()) {
                if (open.contains(ch + "")) stack.push(ch);
                else if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    bw.write("#" + t + " 0\n");
                    continue loop;
                }
            }
            
            bw.write("#" + t + " 1\n");
        }
        
        bw.close();
    }
}