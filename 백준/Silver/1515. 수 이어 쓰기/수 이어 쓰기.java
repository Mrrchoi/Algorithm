import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int base = 0, idx = 0;

        loop: while (base++ <= 30000) {
            String tmp = String.valueOf(base);

            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == s.charAt(idx)) idx++;
                if (idx == s.length()) {
                    bw.write(tmp);
                    break loop;
                }
            }
        }

        bw.close();
    }
}