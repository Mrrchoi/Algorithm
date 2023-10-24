import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n + 1];
        int sum = 0, lidx = 0, ridx = 0, count = 0;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j <= n; j += i) {
                prime[j] = true;
            }
        }

        for(int i = 2; i <= n; i++) {
            if(!prime[i]) list.add(i);
        }

        do {
            if(sum == n) {
                count++;
                sum -= list.get(lidx++);
            }
            else if(sum < n) {
                if(ridx == list.size()) break;
                sum += list.get(ridx++);
            }
            else if(sum > n) {
                sum -= list.get(lidx++);
            }
        } while (lidx != ridx);

        bw.write(count + "");
        bw.close();
    }
}