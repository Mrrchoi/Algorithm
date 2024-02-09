import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if(n <= 205) {
            bw.write("1");
        }
        else if(n <= 217) {
            bw.write("2");
        }
        else if(n <= 228) {
            bw.write("3");
        }
        else {
            bw.write("4");
        }

        bw.close();
    }
}