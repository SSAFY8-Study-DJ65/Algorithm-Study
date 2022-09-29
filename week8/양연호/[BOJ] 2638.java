package m09w3;
/*
 * BOJ : 2638 G3 치즈
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02638 {

	static int N, M, cheeseCnt, res;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	static ArrayList<Point> cheese;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheeseCnt = 0;
		map = new int[N][M];
		cheese = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheese.add(new Point(i, j));
					cheeseCnt += 1;
				}
			}
		}
		
		res = 0;
		while (cheeseCnt != 0) {
			res++;
			visited = new boolean[N][M];
			bfs();
			solution();
		}
		
		System.out.println(res);
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(0, 0));
		visited[0][0] = true;
		map[0][0] = -1;
		
		while (!Q.isEmpty()) {
			Point now = Q.poll();
			int x = now.x;
			int y = now.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1) {
					if (!visited[nx][ny]) {
						visited[nx][ny] = true;
						map[nx][ny] = 2;
						Q.add(new Point(nx, ny));
					}
				}
			}
		}
		
	}

	private static void solution() {
		for (int i = 0; i < cheese.size(); i++) {
			int x = cheese.get(i).x;
			int y = cheese.get(i).y;
			
			int contactCnt = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if (map[nx][ny] == 2) contactCnt++;
			}
			
			if (contactCnt >= 2) {
				map[x][y] = 0;
				cheeseCnt--;
				cheese.remove(i);
				i--;
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
