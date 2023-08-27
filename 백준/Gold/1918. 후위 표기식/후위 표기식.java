import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('(', 0); put(')', 0); put('+', 1); put('-', 1); put('*', 2); put('/', 2);
        }};
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        loop: for(char ch : s.toCharArray()){
            if(Character.isAlphabetic(ch)) bw.write(ch);
            else{
                if(stack.empty() || ch == '(' || map.get(stack.peek()) < map.get(ch)) stack.push(ch);
                else{
                    while(!stack.empty() && map.get(stack.peek()) >= map.get(ch)){
                        if(stack.peek() == '('){
                            stack.pop();
                            continue loop;
                        }
                        bw.write(stack.pop());
                    }

                    stack.push(ch);
                }
            }
        }

        while(!stack.empty()) bw.write(stack.pop());

        bw.close();
    }
}