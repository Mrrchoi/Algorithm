import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] kda = br.readLine().split("/");

        if(Integer.parseInt(kda[1]) == 0 || Integer.parseInt(kda[0]) + Integer.parseInt(kda[2]) < Integer.parseInt(kda[1])) {
            bw.write("hasu");
        }
        else {
            bw.write("gosu");
        }

        bw.close();
    }
}