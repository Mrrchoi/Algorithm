import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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