import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = 1;

        while(true){
            if(b % 2 == 0) b /= 2;
            else if(b % 10 == 1) b /= 10;
            else{
                bw.write("-1");
                break;
            }

            result++;

            if(a == b){
                bw.write(result + "");
                break;
            }
            else if(a > b){
                bw.write("-1");
                break;
            }
        }

        bw.close();
    }
}