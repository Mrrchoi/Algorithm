import java.io.*;

class Solution {
    public static boolean is_palindrome(String s){
        for(int i = 0; i < s.length() / 2; i++) if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return true;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 10; i++){
            int t = Integer.parseInt(br.readLine());
            int max = 1;
            char[][] chArr = new char[100][100];

            for(int j = 0; j < 100; j++) chArr[j] = br.readLine().toCharArray();

            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 100; k++){
                    StringBuffer sb1 = new StringBuffer(chArr[j][k]);
                    StringBuffer sb2 = new StringBuffer(chArr[k][j]);

                    for(int l = k + 1; l < 100; l++){
                        if(is_palindrome(sb1.append(chArr[j][l]).toString())) max = Math.max(max, sb1.length());
                        if(is_palindrome(sb2.append(chArr[l][j]).toString())) max = Math.max(max, sb2.length());
                    }
                }
            }

            bw.write("#" + (i + 1) + " " + max + "\n");
        }

        bw.close();
    }
}