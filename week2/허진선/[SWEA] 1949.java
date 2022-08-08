import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1949 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			k = sc.nextInt();
			
			map = new int[n][n];
			visit = new boolean[n][n];
			int max_high = 0;
			max_len = -1;
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					map[i][j] = sc.nextInt();
					max_high = Math.max(max_high, map[i][j]);
				}
			}
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if(map[i][j] == max_high) {
						dfs(i,j,1,false);
					}
				}
			}
			System.out.println("#"+test_case+" "+max_len);
		}
	}
	
	static int n, k, max_len;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	private static void dfs(int x, int y, int len, boolean dig) {
		visit[x][y] = true;
		max_len = Math.max(max_len, len);
		
		for(int d = 0; d<4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			
			if (nx > -1 && nx < n && ny > -1 && ny < n && !visit[nx][ny]) {
				// 현재 위치 > 다음 위치 - 공사가 불필요한 경우
				if(map[x][y]>map[nx][ny]) {
					dfs(nx, ny, len+1, dig);
				}
				// 현재 위치 <= 다음 위치 - 공사가 필요한 경우
				else if(!dig && map[x][y]>map[nx][ny]-k){
					int temp = map[nx][ny]; // 공사전 상태 저장
					map[nx][ny] = map[x][y] - 1;
					dfs(nx, ny, len+1, true);
					map[nx][ny] = temp;// 공사 전으로 복원 
				}
			}
		}
		visit[x][y] = false;
	}
}
