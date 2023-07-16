import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            Stack<Character> stack = new Stack<>();
            st = new StringTokenizer(br.readLine(), "!");
            String s = st.nextToken();

            if(s.equals(".")) break;

            for(char ch : s.toCharArray()){
                if(ch == '(' || ch == ')' || ch == '[' || ch == ']'){
                    if(stack.size() == 0 || !(stack.peek() == '(' && ch == ')' || stack.peek() == '[' && ch == ']')) stack.push(ch);
                    else stack.pop();
                }
            }

            if(stack.size() == 0) bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
        bw.close();
    }
}