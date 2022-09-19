package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		v = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!v[i][j] && map[i][j] != '#') {
					bfs(i, j);
				}
			}
		}
		System.out.print(sCnt + " " + wCnt);

	}

	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static char[][] map;
	static boolean[][] v;
	static int r, c, sCnt, wCnt;

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		v[x][y] = true;
		
		int s = 0;
		int w = 0;
		
		if (map[x][y] == 'o') {
			s++;
		} else if (map[x][y] == 'v') {
			w++;
		}
		while (q.size() > 0) {
			int[] cur = q.poll();
			for (int[] d : dir) {
				int nx = cur[0] + d[0];
				int ny = cur[1] + d[1];
				if (!check(nx, ny) || v[nx][ny] || map[nx][ny] == '#')
					continue;
				
				q.offer(new int[] { nx, ny });
				v[nx][ny] = true;
				
				if (map[nx][ny] == 'o') {
					s++;
				} else if (map[nx][ny] == 'v') {
					w++;
				}
			}
		}
		if (s > w)
			w = 0;
		else
			s = 0;
		sCnt += s;
		wCnt += w;
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}
}
