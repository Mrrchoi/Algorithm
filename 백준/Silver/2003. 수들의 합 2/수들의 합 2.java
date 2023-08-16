import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        for(int i = 0; i < n; i++){
            int sum = 0;

           for(int j = i; j < n; j++){
               sum += arr[j];

               if(sum == m){
                   count++;
                   break;
               }
               else if(sum > m) break;
           }
        }

        System.out.println(count);

    }
}