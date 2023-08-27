import java.io.*;
import java.util.*;

public class Main {
    public static void z_order(int r, int c, int a, int b, int s, int count){
        if(s == 1){
            System.out.println(count);
            return;
        }

        if(r < a + s / 2 && c < b + s / 2) z_order(r, c, a, b,s / 2,  count);
        else if(r < a + s / 2 && c >= b + s / 2) z_order(r, c, a, b + s / 2,s / 2,  count + (int)Math.pow(s / 2, 2));
        else if(r >= a + s / 2 && c < b + s / 2) z_order(r, c, a + s / 2, b,s / 2,  count + 2 * (int)Math.pow(s / 2, 2));
        else if(r >= a + s / 2 && c >= b + s / 2) z_order(r, c, a + s / 2, b + s / 2,s / 2,  count + 3 * (int)Math.pow(s / 2, 2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int count = 0;

        z_order(r, c,0, 0, (int)Math.pow(2, n), count);
    }
}