import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num =  sc.nextInt() * sc.nextInt() * sc.nextInt();
        int[] arr = new int[10];

        while(num != 0){
            arr[num % 10]++;
            num /= 10;
        }

        for(int k : arr) System.out.println(k);
    }
}