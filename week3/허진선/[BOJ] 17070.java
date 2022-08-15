import java.util.Scanner;

public class BOJ_17070 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		r(0, 1, 0);
		System.out.println(cnt);
	}

	static int n;
	static int cnt;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
	static int[][] poss = { { 0, 1 }, { 0, 1, 2 }, { 1, 2 } }; // 각 상태별로 가능한 다음 방향

	private static void r(int x, int y, int state) {
		if (x == n - 1 && y == n - 1)
			cnt += 1;

		for (int i = 0; i < poss[state].length; i++) {
			int nx = x + dir[poss[state][i]][0];
			int ny = y + dir[poss[state][i]][1];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
				if (poss[state][i] == 1) {
					if(map[nx-1][ny] == 1 || map[nx][ny-1] == 1) continue;
				}
				// System.out.println(nx + ", " + ny);
				r(nx, ny, poss[state][i]);
			}
		}
	}
}
