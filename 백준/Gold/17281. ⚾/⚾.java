import java.io.*;
import java.util.*;

public class Main {
    public static int max = 0;
    public static void permutation(int[][] inning, int depth) {
        if(depth == inning.length) {
            int score = 0, sequence = 0;

            for(int i = 0; i < inning[0].length; i++) {
                boolean[] position = new boolean[3];

                for(int out = 0; out < 3;) {
                    int result = inning[sequence][i];

                    if(result == 0) {
                        out++;
                    }
                    else {
                        for(int j = 2; j >= 0; j--) {
                            if(position[j] && j + result >= 3) {
                                position[j] = false;
                                score++;
                            }
                            else if(position[j]) {
                                position[j] = false;
                                position[j + result] = true;
                            }
                        }

                        if(result == 4) score++;
                        else position[result - 1] = true;
                    }

                    sequence = (sequence + 1) % 9;
                }
            }

            max = Math.max(max, score);

            return;
        }
        else if(depth == 3) {
            permutation(inning, depth + 1);
            return;
        }

        for(int i = depth; i < inning.length; i++) {
            if(i == 3) continue;

            swap(inning, i, depth);
            permutation(inning, depth + 1);
            swap(inning, i, depth);
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
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] inning = new int[9][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 9; j++) {
                inning[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        swap(inning, 0, 3);

        permutation(inning, 0);

        bw.write(max + "");
        bw.close();
    }
}