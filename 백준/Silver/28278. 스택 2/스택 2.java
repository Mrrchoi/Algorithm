import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1) stack.push(Integer.parseInt(st.nextToken()));
            else if(command == 2){
                if(stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.pop() + "\n");
            }
            else if(command == 3) bw.write(stack.size() + "\n");
            else if(command == 4){
                if(stack.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(command == 5){
                if(stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.peek() + "\n");
            }
        }

        bw.close();
    }
}