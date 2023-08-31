import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int val1 = Math.abs(o1);
            int val2 = Math.abs(o2);
            if(val1 == val2) return o1 > o2 ? 1 : -1;
            else return val1 - val2;
        });
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());

            if(k != 0) pq.offer(k);
            else{
                if(pq.size() == 0) bw.write("0\n");
                else bw.write(pq.poll() + "\n");
            }
        }

        bw.close();
    }
}