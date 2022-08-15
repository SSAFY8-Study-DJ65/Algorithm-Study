import java.util.Scanner;

public class d39229 {

	static int max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			max = 0;
			
			int N = sc.nextInt();
			int limit = sc.nextInt();
			
			int arr[] = new int[N];
			int sel[] = new int[2];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			re(arr, sel, 0, 0, limit);
			if(max == 0) max = -1;
			
			System.out.println("#"+tc+" "+max);
		}
	}

	private static void re(int[] arr, int[] sel, int idx, int k, int limit) {
		// TODO Auto-generated method stub

		if (k == sel.length) {
			int sum = 0;
			for(int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum <= limit)
				max = Math.max(max, sum);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			re(arr, sel, i + 1, k + 1, limit);
		}
	}
}
