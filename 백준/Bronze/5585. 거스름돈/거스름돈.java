import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 1000 - Integer.parseInt(br.readLine());
        int[] arr = {500, 100, 50, 10, 5, 1};
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += n / arr[i];
            n %= arr[i];
        }

        bw.write(total + "");
        bw.close();
    }
}