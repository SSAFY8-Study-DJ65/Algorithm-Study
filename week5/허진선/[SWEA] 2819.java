import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2819 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			map = new int[4][4];
			cnt = 0;
			chk = new boolean[10000000]; // 7자리 숫자의 최대값 9999999까지 나타낼수 있음

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 0, 0);
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}

	static int[][] map, dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[] chk;
	static int cnt;

	private static void dfs(int x, int y, int val, int n) {
		// System.out.println(val);
		val += (map[x][y] * Math.pow(10, n));

		if (n == 6) {
			if (!chk[val]) {
				chk[val] = true;
				cnt++;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
				dfs(nx, ny, val, n + 1);
			}
		}
	}
}
