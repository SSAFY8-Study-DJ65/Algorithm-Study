import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	  Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] board = new int[n][n];
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int d = 0;
		
		int x = 0;
		int y = 0;
		
		for(int i =1; i<=n*n; i++) {
			board[x][y] = i;
			x += dx[d];
			y += dy[d];
			
			if((x < 0 || x >= n || y < 0 || y >=n) || board[x][y] != 0) {
				x -= dx[d];
				y -= dy[d];
				
				d = (d + 1) % 4;
				x += dx[d];
				y += dy[d];
			}
			
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
