import java.util.Scanner;

public class SWEA_04615 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] board = new int[N][N];
			
			board[N/2-1][N/2-1] = 2;
			board[N/2-1][N/2] = 1;
			board[N/2][N/2-1] = 1;
			board[N/2][N/2] = 2;
			
			// 델타 ↓/↑/→/←/↘/↖/↗/↙
			int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
			int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
			int mode = 0;

			for (int p = 0; p < M; p++) {
				int X = sc.nextInt()-1;
				int Y = sc.nextInt()-1;
				int S = sc.nextInt();
				
				if (board[X][Y] == 0) {
					board[X][Y] = S;
				}
				
				for (int d = 0; d < 8; d++) {
					int nx = X + dx[d];
					int ny = Y + dy[d];
					
					boolean check = false;
					while (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] != 0) {
						if (board[nx][ny] == S) {
							check = true;
							break;
						}
						
						nx += dx[d];
						ny += dy[d];
					}
				
					while (check) {
						if (nx == X && ny == Y) break;
						board[nx][ny] = S;
						nx -= dx[d];
						ny -= dy[d];
					}
				}
				
			}
			int B_cnt = 0, W_cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) B_cnt++;
					else if (board[i][j] == 2) W_cnt++;
				}
			}
			System.out.println("#" + (tc+1) + " " + B_cnt + " " + W_cnt);
		}
		sc.close();
	}

}
