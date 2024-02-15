import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String vowel = "aeiou";
        String s = br.readLine();
        int count = 0, yCount = 0;

        for(int i = 0; i < s.length(); i++) {
            if(vowel.contains(s.charAt(i) + "")) {
                count++;
            }
            else if(s.charAt(i) == 'y') {
                yCount++;
            }
        }

        bw.write(count + " " + (count + yCount));
        bw.close();
    }
}