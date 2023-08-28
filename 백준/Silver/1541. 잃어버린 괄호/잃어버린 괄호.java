import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        boolean check = true;
        char ch = '+';
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '-'){
                ch = s.charAt(i);
                check = false;
                continue;
            }
            else if(s.charAt(i) == '+'){
                ch = s.charAt(i);
                continue;
            }

            for(int j = i; j <= s.length(); j++){
                if(j == s.length() || !Character.isDigit(s.charAt(j))){
                    int k = Integer.parseInt(s.substring(i, j));
                    if(ch == '+' && check) sum += k;
                    else sum -= k;
                    i = j - 1;
                    break;
                }
            }
        }

        bw.write(sum + "");
        bw.close();
    }
}