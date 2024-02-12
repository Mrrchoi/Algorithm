import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] last = new int[]{arr[0][0], arr[0][1]};
        int total = 0;

        for(int i = 1; i < n; i++) {
            total += Math.abs(arr[i][0] - last[0]) + Math.abs(arr[i][1] - last[1]);
            last[0] = arr[i][0];
            last[1] = arr[i][1];
        }

        for(int i = 1; i < n - 1; i++) {
            int nTotal = total;
            nTotal -= (Math.abs(arr[i + 1][0] - arr[i][0]) + Math.abs(arr[i + 1][1] - arr[i][1])) + (Math.abs(arr[i][0] - arr[i - 1][0]) + Math.abs(arr[i][1] - arr[i - 1][1]));
            nTotal += Math.abs(arr[i + 1][0] - arr[i - 1][0]) + Math.abs(arr[i + 1][1] - arr[i - 1][1]);
            min = Math.min(min, nTotal);
        }

        bw.write(min  + "");
        bw.close();
    }
}