import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] chArr = br.readLine().toCharArray();
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(chArr[i] == 'P') {
                for(int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                    if(chArr[j] == 'H') {
                        chArr[j] = 'X';
                        count++;
                        break;
                    }
                }
            }
        }


        bw.write(count + "");
        bw.close();
    }
}