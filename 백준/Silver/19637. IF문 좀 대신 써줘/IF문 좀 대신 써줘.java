import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] str = new String[n];
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());

            int left = 0, right = n - 1;

            while (left < right) {
                int mid = (left + right) / 2;

                if(k > arr[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }

            bw.write(str[left] + "\n");
        }

        bw.close();
    }
}