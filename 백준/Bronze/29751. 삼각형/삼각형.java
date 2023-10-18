import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double avg = Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken()) / 2;
        System.out.printf("%.1f", avg);
    }
}