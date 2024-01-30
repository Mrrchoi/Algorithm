import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map1 = new HashMap<>();
        int count = 0;

        if(n == 0) {
            bw.write("0");
            bw.close();
            System.exit(0);
        }

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < n - 1; i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            s = br.readLine();

            for(int j = 0; j < s.length(); j++) {
                map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0) + 1);
            }

            for(char ch : map1.keySet()) {
                map2.put(ch, map2.getOrDefault(ch, 0) - map1.get(ch));
                if(map2.get(ch) == 0) map2.remove(ch);
            }

            boolean isOk = true;
            int total = 0;

            if(map2.size() > 2) {
                continue;
            }

            for(char ch : map2.keySet()) {
                if(map2.get(ch) > 1 || map2.get(ch) < -1) {
                    isOk = false;
                }
                else {
                    total += map2.get(ch);
                }
            }

            if(isOk && total >= -1 && total <= 1) count++;
        }

        bw.write(count + "");
        bw.close();
    }
}