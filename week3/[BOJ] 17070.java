import java.util.Scanner;

public class Main {

	static int[][] map;
	static int N, d, ans;
	static int[][] cnt;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		cnt = new int[N+1][N+1];
		
		dfs(1, 2, 0);

		System.out.println(cnt[N][N]);
	}
	
	public static void dfs(int x, int y, int d) {
		if(!check(x, y)) return;
		if(map[x][y] == 1) return;
		
		cnt[x][y]++;
		
		if(d == 0) {
			dfs(x, y+1, 0);
			dfs(x+1, y+1, 2);
		}else if(d == 1) {
			dfs(x+1, y, 1);
			dfs(x+1, y+1, 2);
		}else if(d == 2) {
			if(map[x][y-1] == 1 || map[x-1][y] == 1) return;
			dfs(x, y+1, 0);
			dfs(x+1, y, 1);
			dfs(x+1, y+1, 2);
		}
	}
	
	public static boolean check(int x, int y) {
		if(x <= 0 || x > N || y <= 0 || y > N) {
			return false;
		}
		return true;
	}

}
