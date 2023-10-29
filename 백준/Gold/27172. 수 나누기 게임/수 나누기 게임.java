import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] index = new int[1000001];
        int[] arr = new int[n];
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
             index[arr[i]] = i + 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= Math.sqrt(arr[i]); j++) {
                if(arr[i] % j == 0) {
                    if(index[j] != 0) {
                        answer[index[j] - 1] += 1;
                        answer[index[arr[i]] - 1] -= 1;
                    }
                    if(arr[i] / j != j && arr[i] / j != arr[i] && index[arr[i] / j] != 0) {
                        answer[index[arr[i] / j] - 1] += 1;
                        answer[index[arr[i]] - 1] -= 1;
                    }
                }
            }
        }

        for(int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }

        bw.close();
    }
}