import java.io.*;

public class Main {
   public static void quad(char[][] video, int size, int r, int c) {
       char ch = video[r][c];

        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(ch != video[i][j]) {
                    System.out.print("(");
                    quad(video, size / 2, r, c);
                    quad(video, size / 2, r, c + size / 2);
                    quad(video, size / 2, r + size / 2, c);
                    quad(video, size / 2, r + size / 2, c + size / 2);
                    System.out.print(")");
                    return;
                }
            }
        }

       System.out.print(ch);
   }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] video = new char[n][n];

        for(int i = 0; i < n; i++) {
            video[i] = br.readLine().toCharArray();
        }

        quad(video, n, 0, 0);
    }
}