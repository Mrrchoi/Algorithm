import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long s = Long.parseLong(br.readLine());
        long total = 0, count = 0;

        for (int i = 1; i <= s; i++) {
            count++;
            total += i;

            if (total > s) {
                count--;
                break;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}