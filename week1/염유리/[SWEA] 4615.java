import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[][] board;
	
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	
	static int n;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			n = sc.nextInt();
			int m = sc.nextInt();
			
			board = new int[n][n];
			
			// w:2 b:1
			board[n/2-1][n/2-1] = 2;
			board[n/2][n/2] = 2;
			board[n/2][n/2-1] = 1;
			board[n/2-1][n/2] = 1;
			
			for(int i=0; i<m; i++) {
				
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				
				int color = sc.nextInt();
				
				board[x][y] = color;
				
				for(int d=0; d<8; d++) {
					for(int l=1; l<=n; l++) {
						
						int nx = x+ dx[d]*l;
						int ny = y+ dy[d]*l;
							
						if(nx < 0 || nx >= n || ny < 0 || ny >= n) break;
						
						if(board[nx][ny] == 0) break;
						
						if(board[nx][ny] == color) {
							
							for(int k=1; k<=l; k++) {
								int nnx = nx - dx[d]*k;
								int nny = ny - dy[d]*k;
										
								if(nnx < 0 || nnx >= n || nny < 0 || nny >= n) break;
								board[nnx][nny] = color;
							}
							break;
						}
					}			
				}
			}
			
			int wh = 0;
			int bl = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(board[i][j] == 1) {
						bl += 1;
					}else if(board[i][j] == 2) {
						wh += 1;
					}
				}
			}
			
			System.out.println("#" + t + " " + bl + " " + wh);
		}
	}
}
