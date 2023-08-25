import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int w = Integer.parseInt(s.split(" ")[0]);
        int h = Integer.parseInt(s.split(" ")[1]);
        s = br.readLine();
        int p = Integer.parseInt(s.split(" ")[0]);
        int q = Integer.parseInt(s.split(" ")[1]);
        int t = Integer.parseInt(br.readLine());

        p = ((p + t) / w) % 2 == 0 ? (p + t) % w : w - (p + t) % w;
        q = ((q + t) / h) % 2 == 0 ? (q + t) % h : h - (q + t) % h;

        bw.write(p + " " + q);
        bw.close();
    }
}