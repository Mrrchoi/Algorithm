import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuffer sb = new StringBuffer("I");
        int count = 0;

        for(int i = 0; i < n; i++) sb.append("OI");

        String ioi = sb.toString();

        for(int i = 0; i < s.length() - ioi.length() + 1; i++){
            if(s.charAt(i) == 'O') continue;
            if(s.substring(i, i + ioi.length()).equals(ioi)) count++;
        }

        bw.write(count + "");
        bw.close();
    }
}