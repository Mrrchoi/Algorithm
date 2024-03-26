import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        loop: for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.') {
                while (count != 0) {
                    if(count >= 4) {
                        sb.append("AAAA");
                        count -= 4;
                    }
                    else if(count == 2) {
                        sb.append("BB");
                        count -= 2;
                    }
                    else {
                        sb = new StringBuilder("-1");
                        break loop;
                    }
                }

                sb.append(".");
            }
            else {
                if(++count == 4) {
                    sb.append("AAAA");
                    count = 0;
                }
            }
        }

        if(count == 2) {
            sb.append("BB");
        }
        else if(count != 0) {
            sb = new StringBuilder("-1");
        }

        bw.write(sb.toString());
        bw.close();
    }
}