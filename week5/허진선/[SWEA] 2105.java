import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_2105 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			eat = new boolean[101];
			res = -1;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					endX = i;
					endY = j;
					v = new boolean[n][n];
					dfs(i, j, 0, 0);
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int n, res, endX, endY;
	static int[][] map, dir = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	static boolean[] eat;
	static boolean[][] v;

	private static void dfs(int x, int y, int d, int cnt) {
		if (x == endX && y == endY && d == 3 && cnt >= 4) {
			res = Math.max(res, cnt);
			return;
		}

		for (int i = d; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (check(nx, ny) && !v[nx][ny] && !eat[map[nx][ny]]) {
				v[nx][ny] = true;
				eat[map[nx][ny]] = true;
				dfs(nx, ny, i, cnt + 1);
				v[nx][ny] = false;
				eat[map[nx][ny]] = false;
			}
		}
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
