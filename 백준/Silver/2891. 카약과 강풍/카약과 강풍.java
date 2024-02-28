import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        boolean[] kayak = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < s; i++) {
            kayak[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> extra = new ArrayList<>();

        for(int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;

            if (kayak[num]) {
                kayak[num] = false;
            }
            else {
                extra.add(num);
            }
        }

        for(int num : extra) {
            if(num - 1 >= 0 && kayak[num - 1]) {
                kayak[num - 1] = false;
            }
            else if (num + 1 < n && kayak[num + 1]) {
                kayak[num + 1] = false;
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(kayak[i]) {
                count++;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}