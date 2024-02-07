import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] alpha = br.readLine().split(" ");

        for(int i = 0; i < alpha.length; i++) {
            s = s.replace(alpha[i].charAt(0), alpha[i].toLowerCase().charAt(0));
        }

        bw.write(s);
        bw.close();
    }
}