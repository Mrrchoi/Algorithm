import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1]);

        int total = arr[0][1] - arr[0][0];
        int last = arr[0][1];

        for(int i = 1; i < n; i++) {
            if(arr[i][1] > last) {
                if(arr[i][0] < last) {
                    total += arr[i][1] - last;
                }
                else {
                    total += arr[i][1] - arr[i][0];
                }

                last = arr[i][1];
            }
        }

        bw.write(total + "");
        bw.close();
    }
}