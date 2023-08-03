import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) map.put(sc.nextInt(), 0);

        int m = sc.nextInt();

        for(int i = 0; i < m; i++){
            if(map.containsKey(sc.nextInt())) System.out.println("1");
            else System.out.println("0");
        }
    }
}