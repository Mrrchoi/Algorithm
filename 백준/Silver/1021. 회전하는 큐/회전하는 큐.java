import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        for(int i = 1; i <= n; i++) deque.offer(i);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) queue.offer(Integer.parseInt(st.nextToken()));

        while(queue.size() != 0){
            int num = queue.poll();

            if(num == deque.peekFirst()) {
                deque.pollFirst();
                continue;
            }

            int min = 0;
            //정순환
            for(int i = 0; i < deque.size(); i++){
                deque.addLast(deque.pollFirst());

                if(deque.peekFirst() == num) {
                    min = i + 1;
                    for(int j = 0; j < min; j++) deque.addFirst(deque.pollLast());
                    break;
                }
            }

            //역순환
            for(int i = 0; i < deque.size(); i++){
                deque.addFirst(deque.pollLast());

                if(deque.peekFirst() == num) {
                    if(min >= i + 1) min = i + 1;
                    else for(int j = 0; j < i + min + 1; j++) deque.addLast(deque.pollFirst());
                    break;
                }
            }

            deque.pollFirst();
            count += min;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}