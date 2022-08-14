import java.util.Scanner;

public class Main {

	static int[][] map;
	static int[][] cnt;
	static int N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		cnt = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,1,0);
		
		System.out.println(cnt[N-1][N-1]);

	}
	
	public static boolean check(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) {
			return false;
		}
		return true;
	}
	
	public static void dfs(int x, int y, int d) {
		if(!check(x,y)) return;
		if(map[x][y] == 1) return;
		
		if(d == 0) { // 가로
			dfs(x, y+1, 0);
			dfs(x+1, y+1, 2);
		}else if(d == 1) { // 세로
			dfs(x+1, y, 1);
			dfs(x+1, y+1, 2);
		}else if(d == 2) { // 대각선
			if(map[x-1][y] == 1 || map[x][y-1] == 1) return;
			dfs(x, y+1, 0);
			dfs(x+1, y, 1);
			dfs(x+1, y+1, 2);
		}
		cnt[x][y]++;
	}

}
