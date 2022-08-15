import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4050 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			int sum = 0;

			for (int i = 1; i <= n; i++) {
				if (i % 3 != 0) {
					sum += arr[n - i];
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}
