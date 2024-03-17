import  java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            char[] chArr = br.readLine().toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            int idx = 0;

            for(char ch : chArr) {
                switch (ch) {
                    case '<':
                        idx = Math.max(idx - 1, 0);
                        break;
                    case '>':
                        idx = Math.min(idx + 1, list.size());
                        break;
                    case '-':
                        if(idx > 0) {
                            list.remove(--idx);
                        }
                        break;
                    default:
                        list.add(idx++, ch);
                }
            }

            for(int e : list) {
                bw.write(e);
            }

            bw.newLine();
        }

        bw.close();
    }
}