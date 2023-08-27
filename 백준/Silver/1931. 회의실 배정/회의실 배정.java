import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1]);

        int time = arr[0][1];
        int count = 1;

        for(int i = 1; i < n; i++){
            if(arr[i][0] < time) continue;
            count++;
            time = arr[i][1];
        }

        System.out.println(count);
    }
}