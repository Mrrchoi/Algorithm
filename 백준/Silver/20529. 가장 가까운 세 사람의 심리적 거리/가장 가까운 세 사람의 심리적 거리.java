import java.io.*;
import java.util.*;

public class Main {
    public static int min;
    public static void combination(String[] str,  String[] target, int strIdx, int tgtIdx){
        if(tgtIdx == target.length){
            int sum = 0;

            for(int i = 0; i < 2; i++){
                for(int j = i + 1; j < 3; j++){
                    for(int k = 0; k < 4; k++){
                        if(target[i].charAt(k) != target[j].charAt(k)) sum++;
                    }
                }
            }

            min = min > sum ? sum : min;
            return;
        }
        else if(strIdx == str.length) return;

        target[tgtIdx] = str[strIdx];
        combination(str, target, strIdx + 1, tgtIdx + 1);
        combination(str, target, strIdx + 1, tgtIdx);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            String[] str = new String[n];
            String[] target = new String[3];
            min = Integer.MAX_VALUE;

            for(int j = 0; j < n; j++) str[j] = st.nextToken();
            
            if(n > 32){
                bw.write("0\n");
                continue;
            }

            combination(str, target, 0, 0);

            bw.write(min + "\n");
        }

        bw.close();
    }
}