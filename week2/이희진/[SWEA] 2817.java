import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d32817 {

	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			boolean[] sel = new boolean[N];
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			recursive(arr, sel, 0, 0, K);
			System.out.println("#"+tc+" "+cnt);
		}
	}

	private static void recursive(int[] arr, boolean[] sel, int idx, int k, int K) {
		int sum = 0;
		if (idx == arr.length) {
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					sum += arr[i];
				}
			}
			if (sum == K)
				cnt++;
			return;
		}

		sel[idx] = true;
		recursive(arr, sel, idx + 1, k + 1, K);

		sel[idx] = false;
		recursive(arr, sel, idx + 1, k, K);
	}
}
