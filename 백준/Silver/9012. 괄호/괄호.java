import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            Stack<Character> stack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for(char ch : s.toCharArray()){
                if(stack.size() == 0 || !(stack.peek() == '(' && ch == ')')) stack.push(ch);
                else stack.pop();
            }

            if(stack.size() == 0) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }
}