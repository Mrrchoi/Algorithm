import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long value = 0;
        int max = 0;

        for (long key : map.keySet()) {
            if (max < map.get(key) || (max == map.get(key) && key < value)) {
                value = key;
                max = map.get(key);
            }
        }

        bw.write(value + "");
        bw.close();
    }
}