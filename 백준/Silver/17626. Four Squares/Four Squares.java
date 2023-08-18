import java.io.*;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            if(Math.sqrt(i) % 1 == 0) dp[i] = 1;
            else {
                dp[i] = Integer.MAX_VALUE;
                
                for (int j = 1; j * j < i; j++) dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        bw.write("" + dp[n]);
        bw.close();
    }
}