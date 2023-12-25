import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = 0;

        for(int i = 0; i < 5; i++) {
            total += Math.max( 40, Integer.parseInt(br.readLine()));
        }

        bw.write((total / 5) + "");
        bw.close();
    }
}