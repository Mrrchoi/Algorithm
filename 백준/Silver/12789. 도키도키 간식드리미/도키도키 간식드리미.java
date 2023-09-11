import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int order = 1;
        String answer = "Nice";

        while(st.hasMoreTokens()){
            if(!stack.isEmpty() && stack.peek() == order){
                stack.pop();
                order++;
                continue;
            }

            int k = Integer.parseInt(st.nextToken());

            if(k == order){
                order++;
                continue;
            }

            stack.push(k);
        }

        while(!stack.isEmpty()){
            if(order != stack.pop()) answer = "Sad";
            order++;
        }

        bw.write(answer + "");
        bw.close();
    }
}