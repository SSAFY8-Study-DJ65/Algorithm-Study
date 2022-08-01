import java.util.Scanner;

public class JO_01707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int mode = 0;
		
		int x = 0;
		int y = 0;
		
		matrix[x][y] = 1;
		for (int i = 2; i <= n*n; i++) {
			x = x+dx[mode];
			y = y+dy[mode];
			
			matrix[x][y] = i;
			
			if ((x+dx[mode] >= 0 && x+dx[mode] < n) && (y+dy[mode] >= 0 && y+dy[mode] < n) && (matrix[x+dx[mode]][y+dy[mode]] == 0)) {
				continue;
			}
			
			mode = (mode+1)%4;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
