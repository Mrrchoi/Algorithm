import java.util.*;
import java.io.*;

public class Main {
    public static int count = 0;
    public static void combination(int[] number, int n, int idx) {
        if(idx == number.length) {
            if(++count == n) {
                for(int num : number) System.out.print(num);
                System.exit(0);
            }

            return;
        }

        if(idx == 0) {
            for(int i = number.length - idx - 1; i <= 9; i++) {
                number[idx] = i;
                combination(number, n, idx + 1);
            }
        }
        else {
            for(int i = number.length - idx - 1; i < number[idx - 1]; i++) {
                number[idx] = i;
                combination(number, n, idx + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = -1, count = 0;

        for(int i = 1; i <= 10; i++) {
            combination(new int[i], n, 0);
        }

        bw.write("-1");
        bw.close();
    }
}