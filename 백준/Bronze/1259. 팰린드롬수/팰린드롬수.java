import java.io.*;
import java.util.*;

public class Main {
    public static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String s = br.readLine();
            if(s.equals("0")) break;
            String check = recursion(s, 0, s.length() - 1) == 0 ? "no" : "yes";
            bw.write(check);
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}