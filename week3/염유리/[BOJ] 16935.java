import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n, m, r, max;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		
		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] orders = new int[r];
		
		for(int i=0; i<r; i++) {
			orders[i] = sc.nextInt();
		}
		
		for(int order : orders) {
			if(order == 1) {
				map = compute1(map, n, m);
			}else if(order == 2) {
				map = compute2(map, n, m);
			}else if(order == 3) {
				map = compute3(map, n, m);
				int temp = n;
				n = m;
				m = temp;
			}else if(order == 4) {
				map = compute4(map, n, m);
				int temp = n;
				n = m;
				m = temp;
			}else if(order == 5) {
				map = compute5(map, n, m);
			}else if(order == 6) {
				map = compute6(map, n, m);
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	// 상하 반전
	public static int[][] compute1(int[][] map, int n, int m) {
		int[] temp = new int[m];
		
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<m; j++) {
				temp[j] = map[i][j];
			}
			
			for(int j=0; j<m; j++) {
				map[i][j] = map[n-1-i][j];
			}	
			
			for(int j=0; j<m; j++) {
				map[n-1-i][j] = temp[j];
			}					
		}
		
		return map;
	}
	
	// 좌우 반전
	public static int[][] compute2(int[][] map, int n, int m) {
		int[] temp = new int[n];
		
		for(int i=0; i<m/2; i++) {
			for(int j=0; j<n; j++) {
				temp[j] = map[j][i];
			}
			
			for(int j=0; j<n; j++) {
				map[j][i] = map[j][m-1-i];
			}	
			
			for(int j=0; j<n; j++) {
				map[j][m-1-i] = temp[j];
			}					
		}
		return map;
	}
	
	// 오른쪽 90도 회전
	public static int[][] compute3(int[][] map, int n, int m) {
		int[][] temp = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				temp[i][n-1-j] = map[j][i];
			}
		}
		
		return temp;
	}
	
	// 오른쪽 90도 회전
	public static int[][] compute4(int[][] map, int n, int m) {
		int[][] temp = new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				temp[i][j] = map[j][m-1-i];
			}
		}
		
		return temp;
	}
	
	
	// 부분배열 
	public static int[][] compute5(int[][] map, int n, int m) {
		int[] dx = {0, 0, n/2, n/2, 0};
		int[] dy = {0, m/2, m/2, 0, 0};
		
		int[][] temp = new int[n][m];
		
		for(int d=0; d<4; d++) {
			
			int x = dx[d+1];
			for(int i=dx[d]; i<dx[d]+n/2; i++, x++) {
				int y = dy[d+1];
				for(int j=dy[d]; j<dy[d]+m/2; j++, y++) {
					temp[x][y] = map[i][j];
				}
			}
		}

		return temp;
	}
	
	// 부분배열 
	public static int[][] compute6(int[][] map, int n, int m) {
		int[] dx = {0, n/2, n/2, 0, 0};
		int[] dy = {0, 0, m/2, m/2, 0};
		
		int[][] temp = new int[n][m];
		
		for(int d=0; d<4; d++) {
			
			int x = dx[d+1];
			for(int i=dx[d]; i<dx[d]+n/2; i++, x++) {
				int y = dy[d+1];
				for(int j=dy[d]; j<dy[d]+m/2; j++, y++) {
					temp[x][y] = map[i][j];
				}
			}
		}
		return temp;
	}

}
