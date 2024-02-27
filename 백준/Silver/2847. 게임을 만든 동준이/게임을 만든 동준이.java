import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int last = arr[n - 1];
        int total = 0;

        for(int i = n - 2; i >= 0; i--) {
            if (arr[i] >= last) {
                total += arr[i] - last + 1;
            }

            last = Math.min(arr[i], last - 1);
        }

        bw.write(total + "");
        bw.close();
    }
}