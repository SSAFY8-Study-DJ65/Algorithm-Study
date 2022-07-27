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
			
			for (int p = 0; p < M; p++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				int S = sc.nextInt();
				// 델타 ↓/↑/→/←/↘/↖/↗/↙
				int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
				int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
				int mode = 0;
				
				if (board[X-1][Y-1] != 0) {
					board[X-1][Y-1] = S;
				}
				
//				board[X-1 + dx[mode]]
//				board[]
				
			}
		}
		sc.close();
	}

}
