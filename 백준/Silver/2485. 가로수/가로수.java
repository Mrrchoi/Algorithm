import java.io.*;
import java.util.*;

public class Main {
    public static int Euclidean(int a, int b){
        if(a % b == 0) return b;
        else return Euclidean(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] distance = new int[n - 1];

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);

        for(int i = 1; i < n; i++) distance[i - 1] = arr[i] - arr[i - 1];

        int gcd = distance[0];
        for(int i = 0; i < n - 1; i++){
            gcd = Euclidean(gcd, distance[i]);
        }

        int count = 0;
        for(int i = 0; i < n - 1; i++){
            count += distance[i] / gcd - 1;
        }

        System.out.println(count);
    }
}