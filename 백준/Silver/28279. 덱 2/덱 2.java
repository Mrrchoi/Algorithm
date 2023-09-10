import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1) deque.addFirst(Integer.parseInt(st.nextToken()));
            else if(command == 2) deque.addLast(Integer.parseInt(st.nextToken()));
            else if(command == 3){
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.pollFirst() + "\n");
            }
            else if(command == 4){
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.pollLast() + "\n");
            }
            else if(command == 5) bw.write(deque.size() + "\n");
            else if(command == 6){
                if(deque.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(command == 7){
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.peekFirst() + "\n");
            }
            else if(command == 8){
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.peekLast() + "\n");
            }
        }

        bw.close();
    }
}