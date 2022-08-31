import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	static int[][] map;
	static int N, ans;
	
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {1, -1, -1, 1};
	
	
	static HashSet<Integer> set;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			
			N = sc.nextInt();
			
			map = new int[N][N];
			
			ans = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
						set = new HashSet<>();
						dfs(i, j, 0, i, j, 0);
				}
			}
			
			System.out.println("#" + t + " " + (ans == 0 ? -1 : ans));
		}

	}

	private static void dfs(int startx, int starty, int startd, int x, int y, int d) {
	
		// 시작으로 돌아왔으면
		if(d == 4) {
			if(x == startx && y == starty) { 
				ans = Math.max(ans, set.size());
			}	
			return;
			
		}
			
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx < 0 || nx >= N || ny < 0 || ny >= N) return;
		
		if(!set.contains(map[nx][ny])) {
			set.add(map[nx][ny]);
			
			dfs(startx, starty, startd, nx, ny, d);
			
			dfs(startx, starty, startd, nx, ny, d+1);
			
			set.remove(map[nx][ny]);
		}
	}
}
