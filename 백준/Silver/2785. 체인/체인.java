import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int total = 0, index = n - 1;

        for(int i = 0; i < n; i++) {
            if(arr[i] < index - i) {
                total += arr[i];
                index -= arr[i];
            }
            else {
                total += index - i;
                break;
            }
        }

        System.out.println(total);
    }
}