package m09w4;
/*
 * BOJ : 16954 G3 움직이는 미로 탈출
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16954 {

	static char[][] map;
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};
	static Queue<Point> Q;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		System.out.println(bfs());

	}

	private static void wall() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					map[i][j] = '.';
					if (i != 7) {
						map[i+1][j] = '#';
					}
				}
			}
		}
	}

	private static int bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(7, 0));
		
		while (!Q.isEmpty()) {
			int size = Q.size();
			visited = new boolean[8][8];
			
			for (int i = 0; i < size; i++) {
				Point now = Q.poll();
				int x = now.x;
				int y = now.y;
				
				if (map[x][y] == '#') continue;
				if (x == 0 && y == 7) return 1;
				
				for (int d = 0; d < 9; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && map[nx][ny] != '#') {
						if (!visited[nx][ny]) {
							visited[nx][ny] = true;
							Q.add(new Point(nx, ny));
						}
					}
				}
			}
			wall();
		}
		return 0;
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
