import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = "0" + br.readLine();
        String str2 = "0" + br.readLine();
        int[][] lcs = new int[str1.length()][str2.length()];

        for(int i = 1; i < lcs.length; i++){
            for(int j = 1; j < lcs[i].length; j++) {
                if(str1.charAt(i) == str2.charAt(j)) lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else lcs[i][j] = lcs[i - 1][j] > lcs[i][j - 1] ? lcs[i - 1][j] : lcs[i][j - 1];
            }
        }

        bw.write(lcs[str1.length() - 1][str2.length() - 1] + "");
        bw.close();
    }
}