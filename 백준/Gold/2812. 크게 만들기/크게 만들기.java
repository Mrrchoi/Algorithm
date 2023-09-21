import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int idx = n, len = n - k;

        loop: for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() < s.charAt(i)) {
                stack.pop();
                if(--k == 0) {
                    idx = i;
                    break loop;
                }
            }

            stack.push(s.charAt(i));
        }

        StringBuffer sb = new StringBuffer("");

        while (!stack.isEmpty()) sb.append(stack.pop());

        bw.write(sb.reverse().append(s.substring(idx, n)).substring(0, len).toString());
        bw.close();
    }
}