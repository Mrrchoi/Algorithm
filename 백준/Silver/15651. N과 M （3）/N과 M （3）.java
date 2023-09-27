import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void permutation(int[] target, int idx, int n, int m) throws IOException {
        if(idx == m) {
            for(int num : target)bw.write(num + " ");
            bw.newLine();
            return;
        }

        for(int i = 0; i <n; i++) {
            target[idx] = i + 1;
            permutation(target, idx + 1, n, m);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation(new int[m], 0, n, m);
        bw.close();
    }
}