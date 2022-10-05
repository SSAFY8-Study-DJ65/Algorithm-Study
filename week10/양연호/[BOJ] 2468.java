package m09w5;
/*
 * BOJ : 2468 S1 안전 영역
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02468 {

	static int N, maxHeight, cnt, res;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight,	map[i][j]);
			}
		}
		
		res = 1;
		for (int h = 1; h <= maxHeight; h++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						dfs(h, i, j);
						cnt++;
					}
				}
			}
			res = Math.max(res, cnt);
		}
		
		System.out.println(res);
	}

	private static void dfs(int h, int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if (nx >= 0 & nx < N && ny >= 0 && ny < N && map[nx][ny] > h) {
				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(h, nx, ny);
				}
			}
		}
	}

}
