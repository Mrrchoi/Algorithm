import java.util.*;
import java.io.*;

class Main{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		String s = sc.next();
		
		for(char ch : s.toCharArray()) list.add(ch - '0');
		
		list.sort(Comparator.reverseOrder());
		
		for(int i : list) System.out.print(i);
		
	}
}