import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chArr = br.readLine().toCharArray();
        boolean[] print =  new boolean[chArr.length];
        int zeroCnt = 0, oneCnt = 0;

        for(int i = 0; i < chArr.length ; i++) {
            if(chArr[i] == '0') zeroCnt++;
            else oneCnt++;
        }

        int count = 0;

        for(int i = 0; i < chArr.length; i++) {
            if(chArr[i] == '0') {
                print[i] = true;
                count++;
            }

            if(count == zeroCnt / 2) break;
        }

        count = 0;

        for(int i = chArr.length - 1; i >= 0; i--) {
            if(chArr[i] == '1') {
                print[i] = true;
                count++;
            }

            if(count == oneCnt / 2) break;
        }

        for(int i = 0; i < chArr.length; i++) {
            if(print[i]) bw.write(chArr[i]);
        }

        bw.close();
    }
}