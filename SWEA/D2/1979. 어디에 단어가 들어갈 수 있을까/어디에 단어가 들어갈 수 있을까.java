import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][n];
            int count = 0;

            for(int j = 0; j < n * n; j++) arr[j / n][j % n] = sc.nextInt();

            for(int j = 0; j < n; j++){
                for(int l = 0; l < n; l++){
                    if(arr[j][l] == 0) continue;

                    for(int g = l + 1; g < n; g++){
                        if(arr[j][g] == 0 || g == n - 1){
                            if(g - l + arr[j][g] == k) count++;
                            l = g;
                            break;
                        }
                    }
                }
            }

            for(int j = 0; j < n; j++){
                for(int l = 0; l < n; l++){
                    if(arr[l][j] == 0) continue;

                    for(int g = l + 1; g < n; g++){
                        if(arr[g][j] == 0 || g == n - 1){
                            if(g - l + arr[g][j] == k) count++;
                            l = g;
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + (i + 1) + " " + count);
        }
    }
}