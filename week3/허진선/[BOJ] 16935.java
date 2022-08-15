import java.util.Scanner;

public class BOJ_16935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int r = sc.nextInt();
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < r; ++i) {
			int cmd = sc.nextInt();
			switch (cmd) {
			case 1:
				calc1();
				break;
			case 2:
				calc2();
				break;
			case 3:
				calc3();
				break;
			case 4:
				calc4();
				break;
			case 5:
				calc5();
				break;
			case 6:
				calc6();
				break;
			}
		}
		print(arr);
	}

	static int n, m;
	static int[][] arr;

	private static void print(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void calc1() { // 상하 반전
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				int temp = arr[n - 1 - i][j];
				arr[n - 1 - i][j] = arr[i][j];
				arr[i][j] = temp;
			}
		}
	}

	private static void calc2() { // 좌우 반전
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = arr[i][m - 1 - j];
				arr[i][m - 1 - j] = arr[i][j];
				arr[i][j] = temp;
			}
		}
	}

	private static void calc3() { // +90도
		int[][] new_arr = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				new_arr[j][n - i - 1] = arr[i][j];
			}
		}
		arr = new_arr;
		int temp = n;
		n = m;
		m = temp;
	}

	private static void calc4() { // -90도
		int[][] new_arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				new_arr[i][j] = arr[j][m - i - 1];
			}
		}
		arr = new_arr;
		int temp = n;
		n = m;
		m = temp;
	}

	private static void calc5() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp2 = arr[i][j + m / 2];
				int temp3 = arr[i + n / 2][j + m / 2];
				int temp4 = arr[i + n / 2][j];
				arr[i][j + m / 2] = arr[i][j]; // 2<-1
				arr[i + n / 2][j + m / 2] = temp2; // 3<-2
				arr[i + n / 2][j] = temp3; // 4<-3
				arr[i][j] = temp4; // 1<-4
			}
		}
	}

	private static void calc6() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp2 = arr[i][j + m / 2];
				int temp3 = arr[i + n / 2][j + m / 2];
				int temp4 = arr[i + n / 2][j];

				arr[i + n / 2][j] = arr[i][j]; // 4<-1
				arr[i + n / 2][j + m / 2] = temp4; // 3<-4
				arr[i][j + m / 2] = temp3; // 2<-3
				arr[i][j] = temp2; // 1<-2
			}
		}
	}
}
