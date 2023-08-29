import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("0001101", 0); put("0011001", 1); put("0010011", 2); put("0111101", 3); put("0100011", 4);
            put("0110001", 5); put("0101111", 6); put("0111011", 7); put("0110111", 8); put("0001011", 9);
        }};

        for(int t = 1; t <= test_case; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean check = false;
            int sum = 0, origin = 0;

            for(int i = 0; i < n; i++){
                String s = br.readLine();
                if(!s.contains("1") || check) continue;

                int idx = s.lastIndexOf("1");

                for(int j = 0; j < 8; j++){
                    int k = map.get(s.substring(idx - 7 * (j + 1) + 1, idx - 7 * j + + 1));
                    origin += k;
                    sum += j % 2 == 0 ? k : k * 3;
                }

                check = true;
            }

            if(sum % 10 == 0) bw.write("#" + t + " " + origin + "\n");
            else bw.write("#" + t + " 0\n");
        }

        bw.close();
    }
}