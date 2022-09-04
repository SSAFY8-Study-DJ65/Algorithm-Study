package m08w4;
/*
 * SWEA : 2105 모의 디저트 카페
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_02105 {

	static int T, N, res, sx, sy;
	static int[][] dessert;
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			dessert = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					dessert[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = -1;
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					visited = new boolean[101];
					visited[dessert[i][j]] = true;
					
					sx = i;
					sy = j;
					
					dfs(i, j, -1, -1, 0, 0);
				}
			}
			
			System.out.println("#" + tc + " " + res);
		}
	}


	private static void dfs(int x, int y, int px, int py, int cnt, int direct) {
		for (int d = direct; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if (nx == px && ny == py) continue;
			
			if (nx == sx && ny == sy) {
				res = Math.max(res, cnt+1);
				return;
			}
			
			if (visited[dessert[nx][ny]]) continue;
			
			visited[dessert[nx][ny]] = true;
			dfs(nx, ny, x, y, cnt+1, d);
			
			visited[dessert[nx][ny]] = false;
		}
	}

}
