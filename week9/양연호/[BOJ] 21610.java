package m09w4;
/*
 * BOJ : 21610 G5 마법사 상어와 비바라기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610 {

	static int N, M, d, s, res;
	static int[][] map;
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static Queue<Point> cloud;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cloud = new LinkedList<>();
		cloud.add(new Point(N, 1));
		cloud.add(new Point(N, 2));
		cloud.add(new Point(N-1, 1));
		cloud.add(new Point(N-1, 2));
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1][N+1];
			move();
			rain();
			make();
		}
		
		res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				res += map[i][j];
			}
		}
		System.out.println(res);
	}

	private static void move() {
		while (!cloud.isEmpty()) {
			Point now = cloud.poll();
			
			int x = now.x;
			int y = now.y;
			for (int i = 0; i < s; i++) {
				x += dx[d];
				y += dy[d];
				
				if (x <= 0) x += N;
				else if (x > N) x -= N;
				
				if (y <= 0) y += N;
				else if (y > N) y -= N;
			}
			
			visited[x][y] = true;
			
			map[x][y]++;
		}
	}

	private static void rain() {
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				if (visited[x][y]) {
					int cnt = 0;
					
					for (int d = 0; d < 4; d++) {
						int nx = x+dx[d*2+1];
						int ny = y+dy[d*2+1];
						
						if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
							if (map[nx][ny] != 0)
								cnt++;
						}
					}
					
					map[x][y] += cnt;
				}
			}
		}
	}

	private static void make() {
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				if (!visited[x][y] && map[x][y] >= 2) {
					map[x][y] -= 2;
					cloud.add(new Point(x, y));
				}
			}
		}
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
