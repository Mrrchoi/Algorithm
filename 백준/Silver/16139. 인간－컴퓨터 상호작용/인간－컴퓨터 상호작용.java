import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s = br.readLine();
        int[][] arr = new int[26][s.length()];

        for(int i = 0; i < s.length(); i++) {
            char ch  = s.charAt(i);

            for(int j = 0; j < 26; j++) {
                if(i == 0) break;
                arr[j][i] = arr[j][i - 1];
            }

            arr[ch - 'a'][i]++;
        }

        int q = Integer.parseInt(br.readLine());

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(l == 0) {
                bw.write(arr[ch - 'a'][r] + "\n");
            }
            else {
                bw.write((arr[ch - 'a'][r] - arr[ch - 'a'][l - 1]) + "\n");
            }
        }

        bw.close();
    }
}