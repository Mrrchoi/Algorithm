import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[51];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int result = -1;

        for (int i = 50; i >= 0; i--) {
            if (i == arr[i]) {
                result = i;
                break;
            }
        }

        bw.write(result + "");
        bw.close();
    }
}