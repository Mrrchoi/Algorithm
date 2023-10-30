import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer("");
        int n = Integer.parseInt(br.readLine());
        char[][] stars = new char[n][2 * n - 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(stars[i], ' ');
        }

        sketch(stars, n, 0, n - 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2 * n - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb + "");
        bw.close();
   }
   public static void sketch(char[][] stars, int n, int r, int c) {
       if(n == 3) {
           stars[r][c] = '*';
           stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
           stars[r + 2][c - 2] = stars [r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
       }
       else {
           sketch(stars, n / 2, r, c);
           sketch(stars, n / 2, r + n / 2, c - n / 2);
           sketch(stars, n / 2, r + n / 2, c + n / 2);
       }
   }
}