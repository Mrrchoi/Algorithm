import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int sequence = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if(op.equals("E")) break;

            bw.write("Case " + sequence++ + ": ");

            if(op.equals(">")) bw.write((a > b) + "\n");
            else if(op.equals(">=")) bw.write((a >= b) + "\n");
            else if(op.equals("<")) bw.write((a < b) + "\n");
            else if(op.equals("<=")) bw.write((a <=  b) + "\n");
            else if(op.equals("==")) bw.write((a ==  b) + "\n");
            else if(op.equals("!=")) bw.write((a !=  b) + "\n");
        }
        
        bw.close();
    }
}