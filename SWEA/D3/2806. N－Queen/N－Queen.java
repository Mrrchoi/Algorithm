import java.io.*;

public class Solution {
    public static int[] chess;
    public static int count;
    public static int n;
    public static void n_queen(int idx) {
        if(idx == n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            chess[idx] = i;
            if(promising(idx)) {
                n_queen(idx + 1);
            }
        }
    }
    public static boolean promising(int idx){
        for(int i = 0; i < idx; i++){
            if(chess[i] == chess[idx] || Math.abs(i - idx) == Math.abs(chess[i] - chess[idx])) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            n = Integer.parseInt(br.readLine());
            chess = new int[n];
            count = 0;

            n_queen(0);

            bw.write("#" + t + " " + count + "\n");
        }

        bw.close();
    }
}