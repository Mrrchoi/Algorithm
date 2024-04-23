import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int total = 0, result = 0;

        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= i; j++) {
                total++;

                if (a <= total && total <= b) {
                    result += i;
                }
            }
        }

        bw.write(result + "");
        bw.close();
    }
}