import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());;

        for(int i = 0; i < t; i++){
            Deque<Integer> deque = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();

            int last = 0;
            for(int j = 1; j < value.length() - 1; j++) {
                for (int k = j + 1; k < value.length(); k++) {
                    if (value.charAt(k) == ',' || k == value.length() - 1) {
                        last = k;
                        break;
                    }
                }

                deque.addLast(Integer.parseInt(value.substring(j, last)));
                j = last;
            }

            boolean dir = true; //정방향
            for(int j = 0; j < command.length(); j++) {
                char ch = command.charAt(j);

                if (ch == 'R') dir = !dir;
                else if (ch == 'D' && deque.size() == 0) {
                    bw.write("error\n");
                    break;
                } else if (ch == 'D' && dir) deque.pollFirst();
                else deque.pollLast();

                if (j == command.length() - 1) {
                    bw.write("[");
                    if(dir){
                        while(deque.size() != 0) {
                            bw.write(deque.pollFirst() + "");

                            if(deque.size() == 0) break;
                            else bw.write(",");
                        }
                    }
                    else {
                        while(deque.size() != 0) {
                            bw.write(deque.pollLast() + "");

                            if(deque.size() == 0) break;
                            else bw.write(",");
                        }
                    }
                    bw.write("]\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}