import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> queue =  new LinkedList<>();

        for(int i = 1; i <= n; i++) queue.offer(i);

        while(true){
            if(queue.size() == 1) {
                bw.write(queue.poll() + "\n");
                break;
            }
            
            queue.poll();

            queue.add(queue.poll());
        }

        bw.flush();
        bw.close();
    }
}