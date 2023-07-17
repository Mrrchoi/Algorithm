import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++){
            Queue<Integer> queue = new LinkedList<>();
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) queue.offer(Integer.parseInt(st.nextToken()));

            int turn = 1;
            while(true){
                int k = queue.poll();
                boolean isok = true;

                for(int j = 0; j < queue.size(); j++){
                    if(k < queue.peek()) isok = false;

                    queue.offer(queue.poll());
                }

                if(isok) {
                    if(m == 0) {
                        bw.write(turn + "\n");
                        break;
                    }
                    else turn++;
                }
                else queue.offer(k);

                m = m - 1 >= 0? m -1 : queue.size() - 1;
            }
        }

        bw.flush();
        bw.close();
    }
}