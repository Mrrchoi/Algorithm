import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Map<String, Integer> check = new HashMap<>();

        while(true){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("*")) break;

            boolean isok = true;
            String answer = "surprising";

            loop: for(int i = 1; i < s.length() - 1; i++){
                check.clear();

                for(int j = 0; j < s.length() - i; j++){
                    String sub = Character.toString(s.charAt(j)) + Character.toString(s.charAt(j + i));

                    if(check.containsKey(sub)){
                        isok = !isok;
                        break loop;
                    }

                    check.put(sub, 0);
                }
            }

            if(!isok) answer = "NOT surprising";

            bw.write(s + " is " + answer + ".\n");
        }

        bw.flush();
        bw.close();
    }
}