/*
 * SWEA : 2817 부분 수열의 합
 */
import java.util.Scanner;

public class SWEA_02817 {

	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] num = new int[N];
			for (int i = 0; i < N; i++)
				num[i] = sc.nextInt();
			
			res = 0;
			solve(num, 0, 0, K, N);
			System.out.println("#" + tc + " " + res);
		}
	}
	
	static void solve(int[] num, int idx, int sum, int K, int N) {
		if (sum == K) {
			res++;
			return;
		}
		
		if (idx >= N) {
			return;
		}
		
		solve(num, idx+1, sum+num[idx], K, N);
		
		solve(num, idx+1, sum, K, N);
	}

}
