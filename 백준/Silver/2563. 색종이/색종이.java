import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int[][] arr = new int[n][2];
		int max_x = 0, max_y = 0, count = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = Integer.valueOf(st.nextToken());
			
			if(arr[i][0] > max_x) max_x = arr[i][0];
			if(arr[i][1] > max_y) max_y = arr[i][1];
		}
		
		int[][] dot = new int[max_x + 11][max_y + 11];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = arr[i][0]; j < arr[i][0] + 10; j++) {
				for(int k = arr[i][1]; k < arr[i][1] + 10; k++) {
					dot[j][k] = 1;
				}
			}
		}
		
		for(int i = 0; i < dot.length; i++) {
			for(int j = 0; j < dot[i].length; j++) {
				if(dot[i][j] == 1) count++;
			}
		}
		
		System.out.println(count);
		
	}
}
