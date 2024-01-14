import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][4];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : ((o1[2] != o2[2] ? o2[2] - o1[2] : o2[3] - o1[3])));

        int rank = 1, count = 0;

        if(arr[0][0] == k) {
            bw.write("1");
            bw.close();
            System.exit(0);
        }


        for(int i = 1; i < n; i++) {
            if(arr[i][1] == arr[i - 1][1] && arr[i][2] == arr[i - 1][2] && arr[i][3] == arr[i - 1][3]) {
                count++;
            }
            else {
                rank += count + 1;
                count = 0;
            }

            if(arr[i][0] == k) break;
        }


        bw.write( rank + "");
        bw.close();
    }
}