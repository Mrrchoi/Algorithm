import java.io.*;
import java.util.*;

public class Main {
    public static boolean x_ttt, o_ttt;
    public static void tick_tack_toe(String ttt) {
        for(int i = 0; i < 3; i++) {
            int ch1 = ttt.charAt(i);
            int ch2 = ttt.charAt(3 * i);
            boolean check1 = true;
            boolean check2 = true;

            for(int j = i + 3; j < ttt.length(); j += 3) {
                if(ch1 != ttt.charAt(j)) check1 = false;
            }

            for(int j = 3 * i + 1; j < 3 * i + 3; j++) {
                if(ch2 != ttt.charAt(j)) check2 = false;
            }

            if(check1 && ch1 == 'X') x_ttt = true;
            else if(check1 && ch1 == 'O') o_ttt = true;

            if(check2 && ch2 == 'X') x_ttt = true;
            else if(check2 && ch2 == 'O') o_ttt = true;
        }

        if(ttt.charAt(0) == ttt.charAt(4) && ttt.charAt(4) == ttt.charAt(8)) {
            if(ttt.charAt(0) == 'X') x_ttt = true;
            else o_ttt = true;
        }

        if(ttt.charAt(2) == ttt.charAt(4) && ttt.charAt(4) == ttt.charAt(6)) {
            if(ttt.charAt(2) == 'X') x_ttt = true;
            else o_ttt = true;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String ttt = br.readLine();

            if(ttt.equals("end")) break;

            x_ttt = false;
            o_ttt = false;
            int x_count = 0, o_count = 0;

            for(int i = 0; i < ttt.length(); i++) {
                if(ttt.charAt(i) == 'X') x_count++;
                else if(ttt.charAt(i) == 'O') o_count++;
            }

            if(x_count < o_count || x_count - o_count > 1) {
                bw.write("invalid\n");
                continue;
            }

            tick_tack_toe(ttt);

            if((x_ttt && o_ttt) || (!x_ttt && !o_ttt && x_count + o_count < 9) || (x_ttt && x_count == o_count) || (o_ttt && x_count > o_count)) {
                bw.write("invalid\n");
            }
            else {
                bw.write("valid\n");
            }
        }

        bw.close();
    }
}