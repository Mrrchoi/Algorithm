import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("push_front")) deque.addFirst(Integer.parseInt(st.nextToken()));
			else if(command.equals("push_back")) deque.addLast(Integer.parseInt(st.nextToken()));
			else if(command.equals("pop_front")) {
				if(deque.size() == 0) bw.write("-1\n");
				else bw.write(deque.pollFirst() + "\n");
			}
			else if(command.equals("pop_back")) {
				if(deque.size() == 0) bw.write("-1\n");
				else bw.write(deque.pollLast() + "\n");
			}
			else if(command.equals("size")) bw.write(deque.size() + "\n");
			else if(command.equals("empty")) {
				if(deque.size() == 0) bw.write("1\n");
				else bw.write("0\n");
			}
			else if(command.equals("front")) {
				if(deque.size() == 0) bw.write("-1\n");
				else bw.write(deque.peekFirst() + "\n");
			}
			else if(command.equals("back")) {
				if(deque.size() == 0) bw.write("-1\n");
				else bw.write(deque.peekLast() + "\n");
			}
			
		}
		
		bw.flush();
		bw.close();
	}
}
