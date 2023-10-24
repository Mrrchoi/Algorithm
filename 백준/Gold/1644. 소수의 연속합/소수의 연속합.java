import java.io.*;
import java.util.*;

public class Main {
    public static boolean is_Prime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int sum = 0, lidx = 0, ridx = 0, count = 0;

        for(int i = 2; i <= n; i++) {
            if(is_Prime(i)) list.add(i);
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