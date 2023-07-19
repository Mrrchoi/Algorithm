import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char ch : s.toCharArray()) stack1.push(ch);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("L") && stack1.size() != 0) stack2.push(stack1.pop());
            else if(cmd.equals("D") && stack2.size() != 0) stack1.push(stack2.pop());
            else if(cmd.equals("B") && stack1.size() >= 1) stack1.pop();
            else if(cmd.equals("P")) stack1.push(st.nextToken().charAt(0));
        }

        while(stack1.size() != 0) stack2.push(stack1.pop());
        while(stack2.size() != 0) bw.write(stack2.pop());

        bw.flush();
        bw.close();
    }
}