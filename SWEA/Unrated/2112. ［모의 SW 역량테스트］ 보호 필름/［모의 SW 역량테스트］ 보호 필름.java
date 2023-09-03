import java.io.*;
import java.util.*;

public class Solution {
    public static boolean isOk;
    public static void check(int[][] film, int k){
        for(int i = 0; i < film[0].length; i++){
            int count = 1;
            boolean ok = false;

            for(int j = 0; j < film.length - 1; j++){
                if(film[j][i] == film[j + 1][i]) count++;
                else count = 1;

                if(count == k) ok = true;
            }

            if(!ok) return;
        }

        isOk = true;
    }
    public static void combination(int[][] film, int k, int need, int count, int idx){
        if(count == need){
            check(film, k);
            return;
        }
        else if(idx == film.length) return;

        int[] backup = Arrays.copyOfRange(film[idx], 0, film[0].length);

        Arrays.fill(film[idx], 0);
        combination(film, k, need,count + 1, idx + 1);

        Arrays.fill(film[idx], 1);
        combination(film, k, need,count + 1, idx + 1);

        film[idx] = Arrays.copyOfRange(backup, 0, backup.length);
        combination(film, k, need,count, idx + 1);
    }
    public static int search(int[][] film, int k){
        int need = 0;

        while(true){
            combination(film, k, need, 0, 0);

            if(isOk) return need;

            need++;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] film = new int[d][w];
            isOk = false;

            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) film[i][j] = Integer.parseInt(st.nextToken());
            }

            bw.write("#" + t + " " + search(film, k) + "\n");
        }

        bw.close();
    }
}