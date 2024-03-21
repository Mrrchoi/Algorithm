import  java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int std = 1;
        int copyN = n;
        int count = 0;

        while(copyN != 0) {
            copyN /= 10;
            count++;
        }

        while(std < count) {
            result += std * 9 * Math.pow(10, std - 1);
            std++;
        }

        result += count * (n - Math.pow(10, count - 1) + 1);

        bw.write(result + "");
        bw.close();
    }
}