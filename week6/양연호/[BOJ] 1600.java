package m09w1;
/*
 * BOJ : 1600 G3 말이 되고픈 원숭이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01600 {

	static int K, W, H, res = Integer.MAX_VALUE;
	static int[][] map;
	static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[H][W][K+1];
		res = bfs(0, 0);
		
		if (res == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}

	private static int bfs(int x, int y) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(x, y, 0, K));
		visited[x][y][K] = true;
		
		while (!Q.isEmpty()) {
			Point now = Q.poll();
			if (now.x == H-1 && now.y == W-1) return now.cnt;
			
			for (int d = 0; d < 4; d++) {
				int nx = now.x+dx[d];
				int ny = now.y+dy[d];
				if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0) {
					if (!visited[nx][ny][now.k]) {
						visited[nx][ny][now.k] = true;
						Q.add(new Point(nx, ny, now.cnt+1, now.k));
					}
				}
			}
			
			if (now.k > 0) {
				for (int d = 0; d < 8; d++) {
					int nx = now.x+hdx[d];
					int ny = now.y+hdy[d];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == 0) {
						if (!visited[nx][ny][now.k-1]) {
							visited[nx][ny][now.k-1] = true;
							Q.add(new Point(nx, ny, now.cnt+1, now.k-1));
						}
					}
				}
			}
		}
		
		return res;
	}

	public static class Point {
		int x;
		int y;
		int cnt;
		int k;
		
		Point(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}

}
