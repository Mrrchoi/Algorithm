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
    public static void dfs(int[][] film, int[] target, int k, int idx){
        if(idx == target.length){
            check(film, k);
            return;
        }

        int[] backup = Arrays.copyOfRange(film[target[idx]], 0, film[0].length);

        Arrays.fill(film[target[idx]], 0);
        dfs(film, target, k, idx + 1);

        Arrays.fill(film[target[idx]], 1);
        dfs(film, target, k, idx + 1);

        film[target[idx]] = Arrays.copyOfRange(backup, 0, backup.length);
    }
    public static void combination(int[][] film, int[] target, int value, int tgtIdx, int k){
        if(tgtIdx == target.length){
            dfs(film, target, k, 0);
            return;
        }
        else if(value == film.length) return;

        target[tgtIdx] = value;
        combination(film, target, value + 1, tgtIdx + 1, k);
        combination(film, target, value + 1, tgtIdx, k);

    }
    public static int search(int[][] film, int k){
        int need = 0;

        while(true){
            int[] target = new int[need];

            combination(film, target, 0, 0, k);

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