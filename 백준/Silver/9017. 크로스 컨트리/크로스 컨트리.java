import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] rank = new int[n];
            int min_total = Integer.MAX_VALUE, min_five = Integer.MAX_VALUE, result = 0;

            for(int i = 0; i < n; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
                map.put(rank[i], map.getOrDefault(rank[i], 0) + 1);
            }

            for(int seq : map.keySet()) {
                if (map.get(seq) == 6) continue;

                for(int i = 0; i < n; i++) {
                    if(seq == rank[i]){
                        rank[i] = 0;
                    }
                }
            }

            for(int seq : map.keySet()) {
                if(map.get(seq) != 6) continue;

                int total = 0, five = 0, count = 0, score = 0;

                for(int i = 0; i < n; i++) {
                    if(rank[i] == 0) continue;

                    score++;

                    if(seq == rank[i]) {
                        if(count == 4) {
                            five = score;
                            break;
                        }

                        total += score;
                        count++;
                    }
                }

                if(min_total > total || (min_total == total && min_five > five)) {
                    min_total = total;
                    min_five = five;
                    result = seq;
                }
            }

            bw.write(result + "\n");
        }

        bw.close();
    }
}