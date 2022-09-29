package m09w3;
/*
 * BOJ : 14503 G5 로봇 청소기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {

	static int N, M, R, C, D, res;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = 1;
		recur(R, C, D);
				
		System.out.println(res);
	}

	private static void recur(int r, int c, int d) {
		map[r][c] = 2;
		
		for (int i = 0; i < 4; i++) {
			d = (d+3)%4;
			int nx = r+dx[d];
			int ny = c+dy[d];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
				res++;
				recur(nx, ny, d);
				return;
			}
		}
		
		int nnx = r+dx[(d+2)%4];
		int nny = c+dy[(d+2)%4];
		if (nnx >= 0 && nnx < N && nny >= 0 && nny < M && map[nnx][nny] != 1) {
			recur(nnx, nny, d);
		}
	}

}
