import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[i][0] = l;
            arr[i][1] = h;
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int total = arr[n - 1][1];

        for(int i = 0; i < n - 1;) {
            boolean isBig = false;
            int min = 0, idx = 0;

            for(int j = i + 1; j < n; j++) {
                if(arr[i][1] > arr[j][1] && min <= arr[j][1]) {
                    min = arr[j][1];
                    idx = j;
                }
                else if(arr[i][1] <= arr[j][1]) {
                    idx = j;
                    isBig = true;
                    break;
                }
            }


            if(isBig) {
                total += (arr[idx][0] - arr[i][0]) * arr[i][1];
            }
            else {
                total += (arr[idx][0] - arr[i][0] - 1) * arr[idx][1] + arr[i][1];
            }

            i = idx;
        }

        bw.write(total + "");
        bw.close();
    }
}