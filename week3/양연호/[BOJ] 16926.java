package m08w2;
/*
 * BOJ : 16926 S1 배열 돌리기 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {

	static int N, M, R;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0;  r < R; r++) {
			int mode = Math.min(N, M)/2;
			
			for (int d = 0; d < mode; d++) {
				int x = d;
				int y = d;
				int dir = 0;
				int tmp = map[x][y];
				while(dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= d && nx < N-d && ny >= d && ny < M-d) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					} else {
						dir++;
					}
				}
				map[d+1][d] = tmp;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
