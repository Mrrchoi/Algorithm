import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int total = 0;

            for(int j = 0; j < 20; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 1; j < 20; j++) {
                int idx = -1;

                for(int k = j - 1; k >= 0; k--) {
                    if(list.get(j) < list.get(k)) {
                        idx = k;
                    }
                }

                if(idx >= 0) {
                    int tmp = list.get(j);
                    list.remove(j);
                    list.add(idx, tmp);
                    total += j - idx;
                }
            }

            bw.write(t + " " + total + "\n");
        }

        bw.close();
    }
}