import java.io.*;
import java.util.*;

public class Main {
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int[][] delta_reverse = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static int min = Integer.MAX_VALUE;
    public static void rotate(int[][] arr, int[][] change){
        for(int i = 0; i < change.length; i++) {
            for(int j = 1; j <= change[i][2]; j++) {
                int start_r = change[i][0] - j - 1, start_c = change[i][1] - j - 1;
                int end_r = change[i][0] + j - 1, end_c = change[i][1] + j - 1;
                int next_r = start_r, next_c = start_c;
                int turn = 0, prev = arr[next_r][next_c], next = 0;

                while (turn < 4) {
                    next_r += delta[turn][0];
                    next_c += delta[turn][1];

                    next = arr[next_r][next_c];
                    arr[next_r][next_c] = prev;
                    prev = next;

                    int next_nr = next_r + delta[turn][0];
                    int next_nc = next_c + delta[turn][1];

                    if(next_nr < start_r || next_nr > end_r || next_nc < start_c || next_nc > end_c) turn++;
                }
            }
        }
    }
    public static void rotate_reverse(int[][] arr, int[][] change){
        for(int i = change.length - 1; i >= 0; i--) {
            for(int j = 1; j <= change[i][2]; j++) {
                int start_r = change[i][0] - j - 1, start_c = change[i][1] - j - 1;
                int end_r = change[i][0] + j - 1, end_c = change[i][1] + j - 1;
                int next_r = start_r, next_c = start_c;
                int turn = 0, prev = arr[next_r][next_c], next = 0;

                while (turn < 4) {
                    next_r += delta_reverse[turn][0];
                    next_c += delta_reverse[turn][1];

                    next = arr[next_r][next_c];
                    arr[next_r][next_c] = prev;
                    prev = next;

                    int next_nr = next_r + delta_reverse[turn][0];
                    int next_nc = next_c + delta_reverse[turn][1];

                    if(next_nr < start_r || next_nr > end_r || next_nc < start_c || next_nc > end_c) turn++;
                }
            }
        }
    }
    public static void permutation(int[][] arr, int[][] change, int depth) {
        if(depth == change.length) {
            int result = Integer.MAX_VALUE;

            rotate(arr, change);

            for(int i = 0; i < arr.length; i++) {
                int total = 0;

                for(int j = 0; j < arr[0].length; j++) {
                    total += arr[i][j];
                }

                result = Math.min(result, total);
            }

            rotate_reverse(arr, change);

            min = Math.min(min, result);

            return;
        }

        for(int i = depth; i < change.length; i++) {
            swap(change, i, depth);
            permutation(arr, change, depth + 1);
            swap(change, i, depth);
        }
    }
    public static void swap(int[][] arr, int idx1, int idx2) {
        int[] tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] change = new int[k][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++) {
                change[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(arr, change, 0);

        bw.write(min + "");
        bw.close();
    }
}