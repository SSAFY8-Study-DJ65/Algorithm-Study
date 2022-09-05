package week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_5653 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			res = 0;

			map = new int[n + k + k][m + k + k];
			cells = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						// 현재 (i+k, j+k)에 위치한 세포는 map[i][j]의 생명력을 가졌고 (map[i][j] + 1) 시간이 되면 번식을 시작
						cells.add(new Cell(i + k, j + k, map[i][j], map[i][j] + 1));

						// (생명력만큼 비활성 상태 -> 생명력만큼 활성 상태) => 살아있는 시간: 생명력 X 2
						// (생명력 X 2 > k) => k시간이 지나도 아직 살아 있는 상태
						if (map[i][j] * 2 > k)
							res++;
					}
				}
			}
			Collections.sort(cells);
			bfs();
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int n, m, k, res;
	static int[][] map, dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static ArrayList<Cell> cells;

	static class Cell implements Comparable<Cell> {
		int x;
		int y;
		int life; // 생명력
		int time; // 초기값: 해당 세포가 활성화 되는 시간

		public Cell(int x, int y, int life, int time) {
			this.x = x;
			this.y = y;
			this.life = life; // 생명력만큼 비활성 상태 -> 생명력만큼 활성 상태 -> 죽은 상태
			this.time = time;
		}

		@Override
		public int compareTo(Cell o) {
			// 시간 오름차순 => 생명력 내림차순
			if (this.time == o.time)
				return Integer.compare(o.life, this.life);
			return Integer.compare(this.time, o.time);
		}
	}

	private static void bfs() {
		Cell c = cells.get(0);
		while (c.time <= k) {
			for (int[] d : dir) {
				int nx = c.x + d[0];
				int ny = c.y + d[1];
				if (check(nx, ny) && map[nx][ny] == 0) { // 빈 그리드
					cells.add(new Cell(nx, ny, c.life, c.time + c.life + 1));
					map[nx][ny] = c.life;
					if (c.time + c.life * 2 > k)
						res++;
				}
			}
			cells.remove(0);
			Collections.sort(cells);
			c = cells.get(0);
		}
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
	}
}
