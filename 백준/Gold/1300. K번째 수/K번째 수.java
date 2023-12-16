import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int low = 1, high = k;

        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;

            for(int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        bw.write(high + "");
        bw.close();
    }
}