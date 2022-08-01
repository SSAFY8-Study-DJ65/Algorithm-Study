import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SWEA_6730 { // 장애물 경주 난이도

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 올라가기
			int max_up = 0;
			for (int i = 0; i < n-1; i++) {
				max_up = Math.max(max_up, arr[i+1]-arr[i]);
			}
			// 내려가기
			int max_down = 0;
			for (int i = 0; i < n-1; i++) {
				max_down = Math.max(max_down, arr[i]-arr[i+1]);
			}
			System.out.printf("#%d %d %d\n", test_case, max_up, max_down);
		}
	}
}
