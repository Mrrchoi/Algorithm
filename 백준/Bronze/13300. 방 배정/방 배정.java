import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] student = new int[2][6];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            student[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken()) - 1]++;
        }

        int sum = 0;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 6; j++){
                if(student[i][j] != 0) sum += student[i][j] % k == 0 ? student[i][j] / k : student[i][j] / k + 1;
            }
        }

        bw.write("" + sum);
        bw.close();
    }
}