import java.io.*;
import java.util.*;

public class Main {
    public static String Cantor(String s){
        if(s.length() == 1) return s;
        else{
            String s1 = s.substring(0, s.length() / 3);
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < s.length() / 3; i++) sb.append(" ");

            s1 = Cantor(s1);
            s1 = s1 + sb.toString() + s1;

            return s1;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(sc.hasNext()){
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < (int)Math.pow(3, n); j++) sb.append("-");

            String s = Cantor(sb.toString());

            bw.write(s);
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }
}

