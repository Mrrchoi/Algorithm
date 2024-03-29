import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chArr = br.readLine().toCharArray();
        int[] arr = new int[26];

        for(char ch : chArr) {
            arr[ch - 'a']++;
        }

        for(int num : arr) {
            bw.write(num + " ");
        }

        bw.close();
    }
}