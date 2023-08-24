import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            int idx1 = n / 2, idx2 = n / 2;

            for(int i = 0; i < n; i++){
                String s = br.readLine();
                
                if(i < n / 2){
                    for(int j = idx1; j <= idx2; j++) sum += s.charAt(j) - '0';
                    idx1--;
                    idx2++;
                }
                else{
                    for(int j = idx1; j <= idx2; j++) sum += s.charAt(j) - '0';
                    idx1++;
                    idx2--;
                }
            }

            bw.write("#" + t + " " + sum + "\n");
        }

        bw.close();
    }
}