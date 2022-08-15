import java.util.Scanner;

public class BOJ_16926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int[][] arr = new int[n][m];
		int[][] res = new int[n][m];
		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int frame = Math.min(n, m) / 2;
		for (int i = 0; i < frame; i++) {
			// step 1: 타겟 위치 선정
			int tx = i;
			int ty = i;
			int d2 = 0;
			int new_r = r % ((n-1-i*2) * 2 + (m-1-i*2) * 2);
			for (int j = 0; j < new_r; j++) {
				int nx = tx + dir[d2][0];
				int ny = ty + dir[d2][1];
				if (!(nx >= i && nx < n - i && ny >= i && ny < m - i)) {
					d2++;
				}
				tx += dir[d2][0];
				ty += dir[d2][1];
			}
			// step 2: 타겟 위치에서 부터 번호 기록
			int x = i;
			int y = i;
			int d1 = 0;
			while (true) {
				res[tx][ty] = arr[x][y];
				int nx = x + dir[d1][0];
				int ny = y + dir[d1][1];
				if (!(nx >= i && nx < n - i && ny >= i && ny < m - i)) {
					d1++;
				}
				x += dir[d1][0];
				y += dir[d1][1];

				if (x == i && y == i)
					break;

				nx = tx + dir[d2][0];
				ny = ty + dir[d2][1];
				if (!(nx >= i && nx < n - i && ny >= i && ny < m - i)) {
					d2 = (d2 + 1) % 4;
				}
				tx += dir[d2][0];
				ty += dir[d2][1];
			}
		}
		print(res);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
