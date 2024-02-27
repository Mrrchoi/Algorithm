import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            priorityQueue.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            long result = priorityQueue.poll() + priorityQueue.poll();

            for(int j = 0; j < 2; j++) {
                priorityQueue.add(result);
            }
        }

        long total = 0;

        for(int i = 0; i < n; i++) {
            total += priorityQueue.poll();
        }

        bw.write(total + "");
        bw.close();
    }
}