import java.io.*;
import java.util.*;

public class Main {
    public static int count[] = new int[3];

    public static void paper(int[][] arr, int size, int r, int c) {
        int std = arr[r][c];

        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(std != arr[i][j]) {
                    for(int k = 0; k < 3; k++) {
                        for(int l = 0; l < 3; l++) {
                            paper(arr, size / 3, r + size / 3 * k, c + size / 3 * l);
                        }
                    }

                    return;
                }
            }
        }

        count[std + 1]++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(arr, n, 0, 0);

        for(int i = 0; i < 3; i++) bw.write(count[i] + "\n");

        bw.close();
    }
}