import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();

        for(char ch : s.toCharArray()) {
            if(deque.isEmpty() || deque.peek() >= ch) deque.addFirst(ch);
            else deque.addLast(ch);
        }

        while (!deque.isEmpty()) {
            bw.write(deque.poll() + "");
        }

        bw.close();
    }
}