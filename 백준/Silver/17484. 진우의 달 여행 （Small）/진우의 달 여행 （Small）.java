import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static int[][] delta = {{1, -1}, {1, 0}, {1, 1}};
    public static int min = Integer.MAX_VALUE;
    public static void bruteForce(int[][] arr, Point p, int total, int last) {
        if(p.x == arr.length - 1) {
            min = Math.min(min, total);
            return;
        }

        for(int i = 0; i < delta.length; i++) {
            int nx = p.x + delta[i][0];
            int ny = p.y + delta[i][1];

            if (ny < 0 || ny >= arr[0].length || last == i) continue;

            bruteForce(arr, new Point(nx, ny), total + arr[nx][ny], i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            bruteForce(arr, new Point(0, i), arr[0][i], -1);
        }

        bw.write(min + "");
        bw.close();
    }
}