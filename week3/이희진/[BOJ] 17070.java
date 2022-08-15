import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g517070 {

	static int total;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][N];
		
		total = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		dfs(0, 1, 0, map, N);	
		System.out.println(total);
	}
	
	public static void dfs(int x, int y, int d, int[][] map, int N) {
		if(y == N-1 && x == N-1) {
			total++;
			return;
		}
		//가로
		if(d == 0 || d == 2) {
			if (y < N-1) {
				if(map[x][y+1] == 0)
					dfs(x, y+1, 0, map, N);
			}
		}
		//세로
		if(d == 1 || d == 2) {
			if(x < N-1) {
				if(map[x+1][y] == 0)
					dfs(x+1, y, 1, map, N);
			}
		}
		//대각선
		if(d == 0 || d == 1 || d == 2) {
			if(x < N-1 && y < N-1) {
				if(map[x+1][y+1] == 0 && map[x][y+1] == 0 && map[x+1][y] == 0)
					dfs(x+1, y+1, 2, map, N);
			}
		}
	}
}
