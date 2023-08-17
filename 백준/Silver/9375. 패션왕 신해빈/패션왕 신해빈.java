import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            Map<String, Integer> map = new HashMap<>();
            int n = sc.nextInt();

            sc.nextLine();

            for(int j = 0; j < n; j++){
                String[] s = sc.nextLine().split(" ");
                map.putIfAbsent(s[1], 0);
                map.put(s[1], map.get(s[1]) + 1);
            }

            int result = 1;

            for(String s : map.keySet()) result *= map.get(s) + 1;

            System.out.println(result - 1);
        }
    }
}
