import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);

            while (i - deque.peekFirst() >= l) {
                deque.pollFirst();
            }

            bw.write(arr[deque.peekFirst()] + " ");
        }

        bw.close();
    }
}