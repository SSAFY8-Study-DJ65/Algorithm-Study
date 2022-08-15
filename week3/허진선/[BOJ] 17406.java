import java.util.Scanner;

public class BOJ_17406 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n][m];
		calc = new int[k][3];
		v = new boolean[k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < k; i++) {
			calc[i][0] = sc.nextInt() - 1;
			calc[i][1] = sc.nextInt() - 1;
			calc[i][2] = sc.nextInt();
		}
		r(0, init_arr(n, m));
		System.out.println(min);
	}

	static int n, m, k, min = Integer.MAX_VALUE;
	static int[][] arr, calc, dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[] v;

	private static void print(int[][] map) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		// System.out.println();
	}

	private static int[][] init_arr(int n, int m) {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(arr[i], 0, temp[i], 0, m);
		}
		return temp;
	}

	private static void r(int idx, int[][] map) {
		if (idx == k) {
			for (int i = 0; i < n; i++) {
				int temp = 0;
				for (int j = 0; j < m; j++) {
					temp += map[i][j];
				}
				min = Math.min(min, temp);
			}
			// print(map);
			return;
		}

		for (int i = 0; i < k; i++) {
			if (!v[i]) {
				v[i] = true;
				int sx = calc[i][0] - calc[i][2];
				int sy = calc[i][1] - calc[i][2];
				int ex = calc[i][0] + calc[i][2];
				int ey = calc[i][1] + calc[i][2];
				int frame = Math.min(ex - sx + 1, ey - sy + 1) / 2;
				for (int j = 0; j < frame; j++) {
					int x = sx + j;
					int y = sy + j;
					int d = 0;
					int pre_val = map[x][y];
					while (true) {
						int nx = x + dir[d][0];
						int ny = y + dir[d][1];
						if (!(nx >= sx + j && nx <= ex - j && ny >= sy + j && ny <= ey - j)) {
							if (++d == 4)
								break;
						}
						x += dir[d][0];
						y += dir[d][1];
						int temp = map[x][y];
						map[x][y] = pre_val;
						pre_val = temp;
					}
				}
				r(idx + 1, map);
				v[i] = false;
			}

			if (idx == 0)
				map = init_arr(n, m);
		}
	}
}
