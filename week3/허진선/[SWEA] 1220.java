import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1220 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				boolean flag = false;

				for (int j = 0; j < n; j++) {
					if (map[j][i] == 1) {
						flag = true;
					} else if (map[j][i] == 2 && flag == true) {
						// 파란색을 만났을 때 이전에 빨간색을 만난 적이 있으면 cnt++
						flag = false;
						cnt++;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
