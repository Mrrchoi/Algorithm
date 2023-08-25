import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            String s = br.readLine();
            int count = s.charAt(0) == '1' ? 1 : 0;

            for(int i = 0; i < s.length() - 1; i++){
                if(s.charAt(i) !=  s.charAt(i + 1)) count++;
            }

            bw.write("#" + t + " " + count + "\n");
        }

        bw.close();
    }
}