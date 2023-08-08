import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        loop: for(int i = 0; i < n; i++){
            Stack<Character> stack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for(char ch : s.toCharArray()){ //((()()(()))(((())))()
                //['(', '(' ... juckgima
                if(stack.size() == 0 && ch == ')'){
                    bw.write("NO\n");
                    continue loop;
                }
                else if(ch == '(') stack.push(ch);
                else if(ch == ')') stack.pop();
            }

            if(stack.size() == 0) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }
}