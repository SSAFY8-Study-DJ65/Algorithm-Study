import java.util.Scanner;

public class JO_1707 { // 달팽이사각형

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int nn = n*n;
		int[][] map = new int[n][n];
		int[][] d = {{0,1}, {1, 0}, {0,-1}, {-1, 0}};
		int x = 0;
		int y = 0;
		int i = 1;
		int dir = 0;
		while(i<=nn)
		{
			map[x][y] = i++;
			int nx = x + d[dir][0];
			int ny = y + d[dir][1];
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || (map[nx][ny] != 0)) dir = (dir+1)%4;
			
			x += d[dir][0];
			y += d[dir][1];
		}
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				System.out.print(map[j][k]+" ");
			}
			System.out.println();
		}
	}
}
