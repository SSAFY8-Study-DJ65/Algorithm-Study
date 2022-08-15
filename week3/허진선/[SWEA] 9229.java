import java.util.Scanner;

public class SWEA_9229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			m = sc.nextInt();
			max = -1;
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			r(0, 0, 0);
			System.out.println("#"+test_case+" "+max);
		}
	}

	static int[] arr;
	static int m;
	static int max;
	private static void r(int idx, int cnt, int sum) {
		if (sum > m) return;
		if (cnt == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			r(i+1, cnt+1, sum + arr[i]);
		}
	}
}
