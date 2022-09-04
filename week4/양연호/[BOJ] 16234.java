package m08w3;
/*
 *  BOJ : 16234 G5 인구 이동
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

	static int N, L, R, res;
	static int[][] map;
	static boolean[][] visited;
	static boolean isMove = false;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static ArrayList<Point> union = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move();
		
		System.out.println(res);
	}
	
	private static void move() {
		
		while (true) {
			isMove = false;
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			if (!isMove) break;
			else res++;
		}
	}

	private static void bfs(int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;
		union.add(new Point(x, y));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			x = p.x;
			y = p.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					int tmp = Math.abs(map[x][y] - map[nx][ny]);
					if (!visited[nx][ny] && tmp >= L && tmp <= R) {
						isMove = true;
						visited[nx][ny] = true;
						q.add(new Point(nx, ny));
						union.add(new Point(nx, ny));
					}
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < union.size(); i++) {
			Point p = union.get(i);
			sum += map[p.x][p.y];
		}
		
		for (int i = 0; i < union.size(); i++) {
			Point p = union.get(i);
			map[p.x][p.y] = sum / union.size(); 
		}
		
		union.removeAll(union);
	}

	public static class Point {
		
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
