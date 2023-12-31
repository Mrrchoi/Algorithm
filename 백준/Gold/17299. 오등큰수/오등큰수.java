import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[1000001];
        int[] result = new int[n];

        Arrays.fill(result, -1);

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]]++;
        }

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && count[arr[stack.peek()]] < count[arr[i]]) {
                result[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        for(int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }

        bw.close();
    }
}