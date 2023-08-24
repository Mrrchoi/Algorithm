import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            bw.write("#" + t);

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());

                if(order == 1){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
                else if(order == 2){
                    if(pq.size() == 0) bw.write(" " + -1);
                    else bw.write(" " + pq.poll());
                }
            }

            bw.newLine();
        }

        bw.close();
    }
}