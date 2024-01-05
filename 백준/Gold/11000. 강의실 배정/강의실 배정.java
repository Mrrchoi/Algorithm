import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n  = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 2; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);
        int room = 0;

        for(int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= time[i][0]) {
                pq.poll();
            }

            pq.add(time[i]);
            room = Math.max(room, pq.size());
        }

        bw.write(room + "");
        bw.close();
    }
}