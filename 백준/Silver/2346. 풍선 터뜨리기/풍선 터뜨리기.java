import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =  Integer.parseInt(br.readLine());
        Deque<Point> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            deque.add(new Point(i, Integer.parseInt(st.nextToken())));
        }

        while (true) {
            Point now = deque.pollFirst();

            bw.write(now.x + " ");

            int len = now.y;

            if(len > 0) len--;

            if (deque.isEmpty()) break;

            if(len > 0) {
                for(int i = 0; i < len; i++) deque.addLast(deque.pollFirst());
            }
            else {
                for(int i = len; i < 0; i++) deque.addFirst(deque.pollLast());
            }
        }

        bw.close();
    }
}