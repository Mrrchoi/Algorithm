import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] energy = new int[n];

        for(int i = 0; i < n; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(energy);

        double total = energy[n - 1] + energy[0] / 2.0;

        for(int i = 1; i < n - 1; i++) {
            total += energy[i] / 2.0;
        }

        bw.write(total + "");
        bw.close();
    }
}