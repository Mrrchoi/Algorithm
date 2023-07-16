import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if(order.equals("pop")){
                if(stack.size() == 0) bw.write("-1" + "\n");
                else bw.write(stack.pop() + "\n");
            }
            else if(order.equals("size")) bw.write(stack.size() + "\n");
            else if(order.equals("empty")){
                if(stack.size() == 0) bw.write("1" + "\n");
                else bw.write("0" + "\n");
            }
            else if(order.equals("top")){
                if(stack.size() == 0) bw.write("-1" + "\n");
                else bw.write(stack.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}