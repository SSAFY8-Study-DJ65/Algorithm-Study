package m09w4;
/*
 * BOj : 20058 G4 마법사 상어와 파이어스톰
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058 {

	static int N, Q, total, area;
	static int[] L;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		N = (int)Math.pow(2, N);
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		L = new int[Q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < Q; i++) {
			map = rotate(L[i]);
			map = melt();
		}
		
		total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				total += map[i][j];
			}
		}
		
		area = 0;
		bfs();
		
		sb.append(total).append("\n").append(area);
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					visited[i][j] = true;
					Q.add(new Point(i, j));
					int count = 1;
					
					while(!Q.isEmpty()) {
						Point p = Q.poll();
						int x = p.x;
						int y = p.y;
						
						for (int d = 0; d < 4; d++) {
							int nx = x+dx[d];
							int ny = y+dy[d];
							
							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
								if (map[nx][ny] > 0 && !visited[nx][ny]) {
									visited[nx][ny] = true;
									count++;
									Q.add(new Point(nx, ny));
								}
							}
						}
					}
					
					area = Math.max(area, count);
				}
			}
		}
	}

	private static int[][] melt() {
		int tmp[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				int cnt = 0;
				
				if (map[x][y] == 0) continue;
				
				for (int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						if (map[nx][ny] > 0) {
							cnt++;
						}
					}
				}
				
				if (cnt < 3) {
					tmp[x][y]--;
				}
			}
		}
		return tmp;
	}

	private static int[][] rotate(int l) {
		int[][] tmp = new int[N][N];
		l = (int) Math.pow(2, l);
		for (int i = 0; i < N; i+=l) {
			for (int j = 0; j < N; j+=l) {
				for (int x = 0; x < l; x++) {
					for (int y = 0; y < l; y++) {
						tmp[i+x][j+y] = map[i+l-1-y][j+x];
					}
				}
			}
		}
		
		return tmp;
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
