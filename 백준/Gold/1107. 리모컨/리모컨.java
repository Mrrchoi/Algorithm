import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] broken_button = new boolean[10];
    public static int check_channel(int num){
        int count = 0;

        do{
            if(num < 0 || broken_button[num % 10]) return -1;

            count++;
            num /= 10;
        } while(num != 0);

        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int gap =  Math.abs(n - 100);

        if(m != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) broken_button[Integer.parseInt(st.nextToken())] = true;
        }

        for(int i = 0;; i++){
            int count = i;

            if(count > gap) break;

            int minus = check_channel(n - i);
            int plus = check_channel(n + i);

            if(minus != -1) count += minus;
            else if(plus != -1) count += plus;
            else continue;

            if(gap > count) gap = count;
            break;
        }

        bw.write(gap + "");
        bw.close();
    }
}
