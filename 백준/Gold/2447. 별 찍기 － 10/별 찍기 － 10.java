import java.io.*;
import java.util.*;

public class Main {
    public static StringBuffer sb = new StringBuffer("");
    public static void star(int n, int i, int j) {
        if((i / n) % 3 == 1 && (j / n) % 3 == 1) sb.append(" ");
        else {
            if(n == 1) sb.append("*");
            else star(n / 3, i, j);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =  Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                star(n, i, j);
            }
            sb.append("\n");
        }

        bw.write(sb + "");
        bw.close();
    }
}