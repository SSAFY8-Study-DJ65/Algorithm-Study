package m09w2;
/*
 * BOJ : 3184 S1 양
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_03184 {

	static int R, C, cnt1, cnt2, res1, res2;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		res1 = 0;
		res2 = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j]) {
					if (map[i][j] == 'o' || map[i][j] == 'v') {
						bfs(new Point(i, j));
					}
				}
			}
		}
		
		System.out.println(res1 + " " + res2);
	}
	
	private static void bfs(Point p) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(p);
		visited[p.x][p.y] = true; 
		cnt1 = 0;
		cnt2 = 0;
		
		while (!Q.isEmpty()) {
			Point now = Q.poll();
			if (map[now.x][now.y] == 'o') cnt1++;
			else if (map[now.x][now.y]== 'v') cnt2++;
			
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
					if (map[nx][ny] != '#') {
						visited[nx][ny] = true;
						Q.add(new Point(nx, ny));
					}
				}
			}
		}
		
		if (cnt1 > cnt2) res1 += cnt1;
		else res2 += cnt2;
	}

	static class Point{
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
