import  java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int k = 2;
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while (n != 1) {
                if(n % k == 0) {
                    map.put(k, map.getOrDefault(k, 0) + 1);
                    n /= k;
                }
                else {
                    k++;
                }
            }

            for(int num : map.keySet()) {
                bw.write(num + " " + map.get(num) + "\n");
            }
        }

        bw.close();
    }
}