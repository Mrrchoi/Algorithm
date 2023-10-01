import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n =  Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] structure = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            structure[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            if (structure[i] == 0) deque.addLast(Integer.parseInt(st.nextToken()));
            else st.nextToken();
        }

        int m =  Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            deque.addFirst(Integer.parseInt(st.nextToken()));

            bw.write(deque.pollLast() + " ");
        }

        bw.close();
    }
}