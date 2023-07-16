import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> queue =  new LinkedList<>();
        int last = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                queue.add(last);
            }
            else if(command.equals("pop")){
                if(queue.size() == 0) bw.write("-1\n");
                else bw.write(queue.poll() + "\n");
            }
            else if(command.equals("size")) bw.write(queue.size() + "\n");
            else if(command.equals("empty")){
                if(queue.size() == 0) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(command.equals("front")){
                if(queue.size() == 0) bw.write("-1\n");
                else bw.write(queue.peek() + "\n");
            }
            else if(command.equals("back")){
                if(queue.size() == 0) bw.write("-1\n");
                else bw.write(last + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}