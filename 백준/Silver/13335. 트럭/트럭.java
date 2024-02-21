import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] weight = new int[n];
        int total = 0, idx = 0, time = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        while (idx < n) {
            if(queue.size() == w) {
                total -= queue.poll();
            }

            if(total + weight[idx] <= L) {
                total += weight[idx];
                queue.add(weight[idx++]);
            }
            else {
                queue.add(0);
            }

            time++;
        }

        bw.write((time + w) + "");
        bw.close();
    }
}