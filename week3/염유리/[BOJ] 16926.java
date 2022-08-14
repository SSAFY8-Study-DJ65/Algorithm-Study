import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] map = new int[n][m]; 
	
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int d = 0;
		
		// 몇번 돌리냐 -> 가로세로 중에 짧은거 / 2
		int num = Math.min(n, m) / 2;
		
		while(r-- > 0) {
			for(int i=0; i<num; i++) {
				int x = i;
				int y = i;
				int temp2 =  map[x][y];
				
				while(true) {
					
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < i || nx >= n-i || ny < i || ny >= m-i) {
						nx -= dx[d];
						ny -= dy[d];
						
						d = (d+1) % 4;
						
						nx += dx[d];
						ny += dy[d];
					}	
					
					
					int temp1 = temp2;
					temp2 = map[nx][ny];
					map[nx][ny] = temp1;
					
					x = nx;
					y = ny;
					
					if(x == i && y == i) break;
				}
			}
		
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
