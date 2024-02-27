import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chArr = br.readLine().toCharArray();
        int[] arr = new int[2];

        for(int i = 1; i < chArr.length; i++) {
            if(chArr[i] != chArr[i - 1]) {
                arr[chArr[i - 1] - '0']++;
            }
        }

        arr[chArr[chArr.length - 1] - '0']++;

        bw.write(Math.min(arr[0], arr[1]) + "");
        bw.close();
    }
}