import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.valueOf(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) q.offer(Integer.valueOf(st.nextToken()));
            else if(command.equals("pop")){
                if(q.size() == 0) bw.write("-1\n");
                else bw.write(q.poll() + "\n");
            }
            else if(command.equals("size")) bw.write(q.size() + "\n");
            else if(command.equals("empty")){
                if(q.size() == 0) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(command.equals("front")){
                if(q.size() == 0) bw.write("-1\n");
                else bw.write(q.peekFirst() + "\n");
            }
            else if(command.equals("back")){
                if(q.size() == 0) bw.write("-1\n");
                else bw.write(q.peekLast() + "\n");
            }
        }

        bw.close();
    }
}