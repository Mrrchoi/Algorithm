import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int n = s.length();
        int r = 0, c = 0;

        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                r = i;
                c = n / i;
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                bw.write(s.charAt(i + r * j));
            }
        }

        bw.close();
    }
}