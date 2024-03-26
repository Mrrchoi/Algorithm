import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int start = 1, end = m;
        int total = 0;

        for(int i = 0; i < j; i++) {
            int num = Integer.parseInt(br.readLine());

            if(start < num && end < num) {
                int gap = num - end;
                total += gap;
                end += gap;
                start += gap;
            }
            else if(start > num && end > num) {
                int gap = start - num;
                total += gap;
                end -= gap;
                start -= gap;
            }
        }

        bw.write(total + "");
        bw.close();
    }
}