import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long left = 0, right = n;

        while (left < right) {
            long mid = (left + right) / 2;

            if(mid < n / (mid* 1.0)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        bw.write(left + "");
        bw.close();
    }
}