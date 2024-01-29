import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] score = new int[n + 1][k + 1];
            int[] count = new int[n + 1];
            int[] last = new int[n + 1];

            for(int r = 0; r < m; r++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                score[i][j] = Math.max(score[i][j], s);

                count[i]++;
                last[i] = r;
            }

            int myTeam = 0, rank = 1;

            for(int r = 1; r <= k; r++) {
                myTeam += score[t][r];
            }

            for(int r = 1; r <= n; r++) {
                if(r == t) continue;

                int total = 0;

                for(int c = 1; c <= k; c++) {
                    total += score[r][c];
                }

                if(myTeam < total || (myTeam == total && count[t] > count[r]) || (myTeam == total && count[t] == count[r] && last[t] > last[r])) rank++;
            }

            bw.write(rank + "\n");
        }

        bw.close();
    }
}