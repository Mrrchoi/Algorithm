import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            a = Math.min(a, Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < 2; i++) {
            b = Math.min(b, Integer.parseInt(br.readLine()));
        }

        bw.write((a + b - 50) + "");
        bw.close();
    }
}