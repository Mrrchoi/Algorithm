import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        int[] result = new int[n];
        int value = 1, idx = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            stack.push(value++);
            sb.append("+");

            while(stack.size() != 0 && stack.peek() == arr[idx]) {
                result[idx++] = stack.pop();
                sb.append("-");
            }

            if(value > n){
                while(stack.size() != 0){
                    result[idx++] = stack.pop();
                    sb.append("-");
                }

                break;
            }
        }

        boolean isok = true;
        for(int i = 0; i < n; i++) {
            if (arr[i] != result[i]) {
                isok = false;
                break;
            }
        }

        if(isok) for(char ch : sb.toString().toCharArray()) bw.write(ch + "\n");
        else bw.write("NO");

        bw.flush();
        bw.close();
    }
}