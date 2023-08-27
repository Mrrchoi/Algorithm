import java.util.*;

public class Main {
    static int[] count = new int[2];

    public static void count_paper(int[][] arr, int r, int c, int size){
        int sum = 0;

        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                sum += arr[i][j];
            }
        }

        if(sum == 0) count[0]++;
        else if(sum == size * size) count[1]++;
        else{
            count_paper(arr, r, c, size / 2);
            count_paper(arr, r + size / 2, c, size / 2);
            count_paper(arr, r, c + size / 2, size / 2);
            count_paper(arr, r + size / 2, c + size / 2, size / 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        count_paper(arr, 0, 0, n);

        System.out.println(count[0] + "\n" + count[1]);
    }
}