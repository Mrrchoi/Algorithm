import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		String boom = br.readLine();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			
			if(sb.length() >= boom.length() && sb.substring(sb.length() - boom.length(), sb.length()).equals(boom)) sb.setLength(sb.length() - boom.length());
		}
		
		if(sb.length() == 0) bw.write("FRULA");
		else bw.write("" + sb);
		
		bw.flush();
		bw.close();
	}
}