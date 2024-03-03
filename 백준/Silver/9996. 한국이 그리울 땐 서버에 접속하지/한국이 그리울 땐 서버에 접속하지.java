import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] std = br.readLine().split("\\*");
        int len = std[0].length() + std[1].length();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            if(s.length() < len) {
                bw.write("NE\n");
            }
            else if(s.startsWith(std[0]) && s.endsWith(std[1])) {
                bw.write("DA\n");
            }
            else {
                bw.write("NE\n");
            }
        }

        bw.close();
    }
}