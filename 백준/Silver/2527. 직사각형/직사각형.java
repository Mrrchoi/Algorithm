import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int[] dot = new int[8];

            for(int j = 0; j < 8; j++) dot[j] = Integer.parseInt(st.nextToken());

            if(dot[2] < dot[4] || dot[6] < dot[0] || dot[3] < dot[5] || dot[7] < dot[1]) bw.write("d\n");
            else if((dot[2] == dot[4] || dot[0] == dot[6]) && ((dot[1] == dot[7]) || dot[3] == dot[5])) bw.write("c\n");
            else if(dot[2] == dot[4] || dot[0] == dot[6] || dot[1] == dot[7] || dot[3] == dot[5]) bw.write("b\n");
            else bw.write("a\n");

        }

        bw.close();
    }
}