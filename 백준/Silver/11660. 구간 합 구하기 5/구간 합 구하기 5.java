import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] table = new int[n][n];
        
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            
            table[i][0] = Integer.parseInt(st.nextToken());
            
            for(int j = 1; j < n; j++) table[i][j] = table[i][j - 1] + Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int result = 0;
            
            for(int j = y1 - 1; j < y2; j++){
                result += table[j][x2 - 1];
                
                if(x1 - 2 >= 0) result -= table[j][x1 - 2];
            }
            
            bw.write(result + "\n");
            
        }
        
        bw.close();
    }
}
