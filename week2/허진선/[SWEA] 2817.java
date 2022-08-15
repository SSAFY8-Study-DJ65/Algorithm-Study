import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_2817 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			boolean[] sel = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println("#"+test_case+" "+poserSet(arr, sel, 0, 0, k));
		}
	}

	public static int poserSet(int[] arr, boolean[] sel, int idx, int sum, int k) {
		if(idx == arr.length) {
			if(sum == k) return 1;
			else return 0;
		}
		
		sel[idx] = true;
		sum += arr[idx];
		int temp1 = poserSet(arr, sel, idx+1, sum, k);
		
		sel[idx] = false;
		sum -= arr[idx];
		int temp2 = poserSet(arr, sel, idx+1, sum, k);
		return temp1 + temp2;
	}
}
