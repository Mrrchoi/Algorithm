import java.util.*;
import java.io.*;

public class Main {
    public static int install(int[] home, int distance) {
        int count = 1;
        int last = home[0];

        for(int i = 1; i < home.length; i++) {
            if(home[i] - last >= distance) {
                last = home[i];
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] home = new int[n];

        for(int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);
        int low = 1;
        int high = home[n - 1] - home[0] + 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if(install(home, mid) < c) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        bw.write((low - 1) + "");
        bw.close();
    }
}