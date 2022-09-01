import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16234_RE {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int res = 0;
		while (true) {
			boolean flag = false;
			v = new boolean[n][n];
			
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (v[x][y])
						continue;
					Pos p = bfs(x, y);
					if (p.cnt != 0) {
						int val = p.sum / p.cnt;
						for (int i = 0; i < p.cnt; i++) {
							map[p.list.get(i)[0]][p.list.get(i)[1]] = val;
						}
						print(map);
						flag = true;
					}
				}
			}
			System.out.println(res);
			if(flag) res++;
			else break;
		}
	
	}

	static int n, l, r, map[][], dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean v[][];

	static class Pos {
		ArrayList<int[]> list;
		int sum;
		int cnt;

		public Pos() {
			this.list = new ArrayList<>();
			this.sum = 0;
			this.cnt = 0;
		}
	}

	private static Pos bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		Pos p = new Pos();
		q.offer(new int[] { i, j });
		v[i][j] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			p.list.add(new int[] { x, y });
			p.sum += map[x][y];
			p.cnt++;

			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (check(nx, ny) && v[nx][ny] == false) {
					if (Math.abs(map[x][y] - map[nx][ny]) <= r && Math.abs(map[x][y] - map[nx][ny]) >= l) {
						q.offer(new int[] { nx, ny });
						v[nx][ny] = true;
					}
				}
			}
		}
		return p;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
