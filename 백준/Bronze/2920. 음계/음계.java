import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        boolean check1 = true;
        boolean check2 = true;

        for(int i = 0; i < 8; i++) arr[i] = sc.nextInt();

        for(int i = 0; i < 8; i++){
            if(arr[i] != i + 1) check1 = false;
            if(arr[i] != 8 - i) check2 = false;
        }

        if(check1) System.out.println("ascending");
        else if(check2) System.out.println("descending");
        else System.out.println("mixed");
    }
}