import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> rank = new HashMap<Character, Integer>(){{
            put('(', 0); put(')', 0); put('+', 1); put('-', 1); put('*', 2); put('/', 2);
        }};

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            StringBuffer sb = new StringBuffer();

            Stack<Character> stack = new Stack<>();

            for(char ch : s.toCharArray()){
                if(ch >= '0' && ch <= '9') sb.append(ch);
                else if(ch == '(') stack.push(ch);
                else{
                    while(!stack.empty() && rank.get(ch) <= rank.get(stack.peek())){
                        if(stack.peek() == '('){
                            stack.pop();
                            break;
                        }

                        sb.append(stack.pop());
                    }

                    if(ch != ')') stack.push(ch);
                }
            }

            while(!stack.empty()) sb.append(stack.pop());

            Stack<Integer> cal = new Stack<>();

            for(char ch : sb.toString().toCharArray()){
                if(ch >= '0' && ch <= '9') cal.push(ch - '0');
                else{
                    if(ch == '+') cal.push(cal.pop() + cal.pop());
                    else if(ch == '-') cal.push(cal.pop() - cal.pop());
                    else if(ch == '*') cal.push(cal.pop() * cal.pop());
                    else if(ch == '/') cal.push(cal.pop() / cal.pop());
                }
            }

            bw.write("#" + t + " " + cal.pop() + "\n");
        }

        bw.close();
    }
}