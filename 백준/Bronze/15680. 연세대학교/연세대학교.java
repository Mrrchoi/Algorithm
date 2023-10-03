import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int value = Integer.parseInt(br.readLine());

        if (value == 0) bw.write("YONSEI");
        else bw.write("Leading the Way to the Future");

        bw.close();
    }
}