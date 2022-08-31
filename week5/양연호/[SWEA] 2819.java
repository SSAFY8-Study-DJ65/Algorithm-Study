package m08w4;
/*
 * SWEA : 2819 D4 격자판의 숫자 이어 붙이기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class SWEA_02819 {

	static int T, N = 4;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, ""+arr[i][j], 1);
				}
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}

	private static void dfs(int x, int y, String num, int idx) {
		
		if (idx == 7) {
			set.add(num);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				dfs(nx, ny, num+arr[nx][ny], idx+1);
			}
		}
	}
}
