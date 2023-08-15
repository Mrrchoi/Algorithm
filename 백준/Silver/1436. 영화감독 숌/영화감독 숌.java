import java.util.*;
import java.io.*;

class Main{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 666;;i++) {
			if(Integer.toString(i).contains("666")) count++;
			
			if(count == n) {
				System.out.println(i);
				break;
			}
		}
		
	}
}