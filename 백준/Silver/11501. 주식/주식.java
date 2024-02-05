import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            Stack<Integer> stack = new Stack<>();
            long total = 0;
            int max = 0, n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            while (!stack.isEmpty()) {
                if(max < stack.peek()) {
                    max = stack.pop();
                }
                else {
                    total += max - stack.pop();
                }
            }

            bw.write(total + "\n");
        }

        bw.close();
    }
}