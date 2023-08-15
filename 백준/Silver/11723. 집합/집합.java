import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int bit = 0, value = 0;
        int n = Integer.valueOf(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(!str.equals("all") && !str.equals("empty")) value = Integer.parseInt(st.nextToken());

            if(str.equals("add")) bit |= (1 << value);
            else if(str.equals("remove")) bit &= ~(1 << value);
            else if(str.equals("check")){
                if((bit & (1 << value)) != 0){
                    bw.write("1\n");
                }
                else {
                    bw.write("0\n");
                }
            }
            else if(str.equals("toggle")) bit ^= (1 << value);
            else if(str.equals("all")) bit = (1 << 21) - 1;
            else if(str.equals("empty")) bit = 0;
        }

        bw.flush();
        bw.close();
    }
}