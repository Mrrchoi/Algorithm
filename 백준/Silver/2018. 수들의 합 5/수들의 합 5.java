import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 1, left = 1, right = Math.min(2, n);

        while (left < right && left <= n / 2) {
            int total = (left + right) * (right - left + 1) / 2;

            if (total < n) {
                right++;
            }
            else {
                if(total == n) {
                    count++;
                }

                left++;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}