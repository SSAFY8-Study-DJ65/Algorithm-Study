import java.util.Scanner;

public class Solution {

	static int N, K, ans;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					max = Math.max(max, map[r][c]);
				}
			}
			
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					for (int k = 1; k <= K; k++) {
						
						map[i][j] -= k;
						
						visited = new boolean[N][N];
						
						for (int r = 0; r < N; r++) {
							for (int c = 0; c < N; c++) {
								
								if(map[r][c] == max) {
									dfs(r, c, 1);	
								}
								
							}
						}
						
						map[i][j] += k;
					}
					
				}
				
			}
			
			System.out.println("#" + t + " "  + ans);
		}

	}
	
	private static void dfs(int r, int c, int len) {
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			
			int nx = r + dx[d];
			int ny = c + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(visited[nx][ny]) continue;
			if(map[r][c] <= map[nx][ny]) continue;
			
			
			dfs(nx, ny, len+1);
			
			
		}
		visited[r][c] = false;
		ans = Math.max(ans, len);
	}

}
