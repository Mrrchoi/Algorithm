import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine().replaceAll("\\d+","");
        String s2 = br.readLine();

        bw.write((s1.contains(s2) ? 1 : 0) + "\n");
        bw.close();
    }
}