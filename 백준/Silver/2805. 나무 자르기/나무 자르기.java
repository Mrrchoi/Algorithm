import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int left = 0, right = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > right) right = arr[i];
        }

        while(left <= right){
            int mid = (left + right) / 2;
            long sum = 0;

            for(int i = 0; i < n; i++) sum += arr[i] > mid ? arr[i] - mid : 0;

            if(sum >= m) left = mid + 1;
            else if(sum < m) right = mid - 1;
        }

        System.out.println(right);
    }
}