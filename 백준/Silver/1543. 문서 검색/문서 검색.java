import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int count = 0;

        for(int i = 0; i <= s1.length() - s2.length(); ) {
            if(s1.substring(i, i + s2.length()).equals(s2)) {
                count++;
                i += s2.length();
            }
            else {
                i++;
            }
        }

        bw.write(count + "");
        bw.close();
    }
}