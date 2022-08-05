import java.util.Scanner;

public class SWEA_01949 {

	static int N, K, max, res;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			max = 0;
			res = 0;
			
			arr = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (max < arr[i][j])
						max = arr[i][j];
				}
			}
			start();
			System.out.println("#" + tc + " " + res);
			
			
			
		}
	}
	
	static void start() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == max) {
					visited[i][j] = true;
					dfs(i, j, max, 1, 0);
					visited[i][j] = false;
				}
			}
		}
	}
	
	
	static void dfs(int x, int y, int height, int length, int shaveCnt) {
		for (int d = 0; d < 4; d++) {
			if (res < length) res = length;
			
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
				continue;
			
			if (height <= arr[nx][ny]) {
				if (shaveCnt == 0) {
					if (height > arr[nx][ny] - K) {
						visited[nx][ny] = true;
						dfs(nx, ny, height-1, length+1, shaveCnt+1);
						visited[nx][ny] = false;
					}
				}
			} else {
				visited[nx][ny] = true;
				dfs(nx, ny, arr[nx][ny], length+1, shaveCnt);
				visited[nx][ny] = false;
			}
		}
		
		
	}

}
