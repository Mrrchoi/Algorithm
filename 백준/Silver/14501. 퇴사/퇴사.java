import java.util.Scanner;

public class Main {
	public static int answer = 0;
	
	public static void main(String[] args) {
		// 입력
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] T = new int[N]; // 상담에 걸리는 시간
		int[] P = new int[N]; // 받을 수 있는 금액
		for(int i = 0; i < N; i++) {
			T[i] = scanner.nextInt();
			P[i] = scanner.nextInt();
		}
		scanner.close();
		// 계산
		work(T, P, 1, N-1, 0);
		// 출력
		System.out.println(answer);
	}
	
	public static void work(int[] T, int[] P, int date, int start, int tmp) {
		answer = Math.max(tmp, answer);
		for(int i = start; i >= 0; i--) {
			if(T[i] <= date) work(T, P, 1, i-1, tmp+P[i]);
			date++;
		}
	}
}