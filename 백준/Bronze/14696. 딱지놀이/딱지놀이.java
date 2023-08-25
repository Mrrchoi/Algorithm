import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.valueOf(br.readLine());

        loop: for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] a_card = new int[5];
            st.nextToken();
            while(st.hasMoreTokens()) a_card[Integer.parseInt(st.nextToken())]++;

            st = new StringTokenizer(br.readLine());
            int[] b_card = new int[5];
            st.nextToken();
            while(st.hasMoreTokens()) b_card[Integer.parseInt(st.nextToken())]++;

            for(int j = 4; j >= 1; j--){
                if(a_card[j] > b_card[j]) {
                    bw.write("A\n");
                    continue loop;
                }
                else if(a_card[j] < b_card[j]) {
                    bw.write("B\n");
                    continue loop;
                }
            }

            bw.write("D\n");
        }

        bw.close();
    }
}