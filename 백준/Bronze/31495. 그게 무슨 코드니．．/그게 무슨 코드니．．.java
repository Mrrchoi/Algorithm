import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        if (s.startsWith("\"") && s.endsWith("\"") && s.length() > 2) {
            bw.write(s.substring(1, s.length() - 1));
        }
        else {
            bw.write("CE");
        }

        bw.close();
    }
}