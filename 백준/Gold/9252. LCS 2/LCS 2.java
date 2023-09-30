import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = "0" + br.readLine();
        String s2 = "0" + br.readLine();
        int[][] dp = new int[s1.length()][s2.length()];

        for(int i = 1; i < s1.length(); i++) {
            for(int j = 1; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
            }
        }

        bw.write(dp[s1.length() - 1][s2.length() - 1] + "\n");

        StringBuffer sb = new StringBuffer("");
        int r = s1.length() - 1, c = s2.length() - 1;

        while (r > 0 && c > 0) {
            if(dp[r][c] == dp[r - 1][c]) {
                r--;
            }
            else if(dp[r][c] == dp[r][c - 1]) {
                c--;
            }
            else {
                sb.append(s1.charAt(r));
                r--;
                c--;
            }
        }

        bw.write(sb.reverse().toString());
        bw.close();
    }
}