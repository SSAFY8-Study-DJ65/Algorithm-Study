package m09w5;
/*
 * BOJ : 2665 G4 미로만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_02665 {
	
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = 0;
		bfs();
		
		System.out.println(dist[N-1][N-1]);
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(0, 0));
		
		while (!Q.isEmpty()) {
			Point now = Q.poll();
			int x = now.x;
			int y = now.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] > dist[x][y]) {
					if (map[nx][ny] == 1) {
						dist[nx][ny] = dist[x][y];
					}
					else {
						dist[nx][ny] = dist[x][y] + 1;
					}
					Q.add(new Point(nx, ny));
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
