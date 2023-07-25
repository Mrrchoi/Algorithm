import java.util.*;
import java.io.*;

class Main{
	public static int[][] sorted;
	
	public static void merge_sort(int[][] arr) {
		sorted = new int[arr.length][2];
		
		merge_sort(arr, 0, arr.length - 1);
		
		sorted = null;
		
	}
	private static void merge_sort(int[][] arr, int left, int right) {
		if(left == right) return;
		
		int mid = (left + right) / 2;
		
		merge_sort(arr, left, mid);
		merge_sort(arr, mid + 1, right);
		
		merge(arr, left, mid, right);
		
	}
	
	public static void merge(int arr[][], int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;
		
		while(l <= mid && r <= right) {
			if(arr[l][0] < arr[r][0] ||(arr[l][0] == arr[r][0]) && arr[l][1] <= arr[r][1]) {
				sorted[idx][0] = arr[l][0];
				sorted[idx][1] = arr[l][1];
				idx++;
				l++;
			}
			else {
				sorted[idx][0] = arr[r][0];
				sorted[idx][1] = arr[r][1];
				idx++;
				r++;
			}
			
			if(l > mid) {
				while(r <= right) {
					sorted[idx][0] = arr[r][0];
					sorted[idx][1] = arr[r][1];
					idx++;
					r++;
				}
			}
			
			if(r > right) {
				while(l <= mid) {
					sorted[idx][0] = arr[l][0];
					sorted[idx][1] = arr[l][1];
					idx++;
					l++;
				}
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i][0] = sorted[i][0];
			arr[i][1] = sorted[i][1];
		}
	}
	public static void swap(int[][] arr, int i, int j) {
		int tmp = arr[i][0];
		arr[i][0] = arr[j][0];
		arr[j][0] = tmp;
		
		tmp = arr[i][1];
		arr[i][1] = arr[j][1];
		arr[j][1] = tmp;
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) arr[i][j] = Integer.valueOf(st.nextToken());
		}
		
		//Merge
		merge_sort(arr);
		
		for(int i = 0; i < n; i++) bw.write(arr[i][0] + " " + arr[i][1] + "\n");
		
		bw.flush();
		bw.close();
		
	}
}