package week6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][w];
		v = new boolean[h][w][31]; // K는 0이상 30이하의 정수 => 31개의 공간 필요
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		res = -1;
		bfs();
		System.out.println(res);
	}

	static int k, w, h, res;
	static int[][] map;
	static int[][] dir1 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] dir2 = { { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };
	static boolean[][][] v;

	static class Pos {
		int x;
		int y;
		int cnt;
		int k;

		Pos(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}

	private static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(0, 0, 0, k));

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int k = cur.k;

			if (x == w - 1 && y == h - 1) {
				res = cnt;
				break;
			}

			if (!check(x, y) || map[y][x] == 1 || v[y][x][k])
				continue;

			v[y][x][k] = true;

			for (int[] d : dir1) {
				q.add(new Pos(x + d[0], y + d[1], cnt + 1, k));

			}

			if (k == 0)
				continue;

			for (int[] d : dir2) {
				q.add(new Pos(x + d[0], y + d[1], cnt + 1, k - 1));
			}
		}
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < w && y >= 0 && y < h;

	}
}
