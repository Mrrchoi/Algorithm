import java.io.*;
import java.util.*;
import java.awt.Point;

public class Solution {
    public static Point[] customer;
    public static Point home;
    public static Point company;
    public static Point[] target;
    public static boolean[] visit;
    public static int min_distance;

    public static void permutation(int tgtIdx){
        if(tgtIdx == target.length){
            int distance = 0;

            distance += Math.abs(company.x - target[0].x) + Math.abs(company.y - target[0].y);
            distance += Math.abs(target[target.length - 1].x - home.x) + Math.abs(target[target.length - 1].y - home.y);

            for(int i = 0; i < target.length - 1; i++){
                distance += Math.abs(target[i].x - target[i + 1].x) + Math.abs(target[i].y - target[i + 1].y);
                if(distance > min_distance) return;
            }

            min_distance = distance;

            return;
        }

        for(int i = 0; i < customer.length; i++){
            if(!visit[i]){
                target[tgtIdx] = customer[i];
                visit[i] = true;
                permutation(tgtIdx + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            customer = new Point[n];
            target = new Point[n];
            visit = new boolean[n];
            min_distance = Integer.MAX_VALUE;

            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for(int i = 0; i < n; i++){
                customer[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            permutation(0);

            bw.write("#" + t + " " + min_distance + "\n");
        }

        bw.close();
    }
}