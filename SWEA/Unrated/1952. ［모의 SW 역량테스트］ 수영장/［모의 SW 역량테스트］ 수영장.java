import java.util.*;
import java.io.*;

class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void topoSort(ArrayList<Integer>[] graph, int[] edgeCnt, int t) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < edgeCnt.length; i++) {
            if(edgeCnt[i] == 0) queue.offer(i);
        }

        bw.write("#" + t);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            bw.write(" " + now);

            for(int next : graph[now]) {
                edgeCnt[next]--;

                if(edgeCnt[next] == 0) queue.offer(next);
            }
        }

        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int[] price = new int[4];
            int[] month = new int[13];
            int[] dp = new int[13];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 4; i++) price[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for(int i = 1; i <= 12; i++) month[i] = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= 12; i++) {
                dp[i] = Math.min(price[0] * month[i], price[1]) + dp[i - 1];
                if (i >= 3) dp[i] = Math.min(dp[i], price[2] +  dp[i - 3]);
                if (i == 12) dp[i] = Math.min(dp[i], price[3]);
            }

            bw.write("#" + t + " " + dp[12] + "\n");

        }

        bw.close();
    }
}