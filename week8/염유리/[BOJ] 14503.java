import java.util.Scanner;

/*
 * G5 로봇 청소기
 */
public class Main {

	static int[][] map;
	
	// 북 동 남 서
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
//	static int[] dx = {0, 1, 0,	-1};
//	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		int tmp = d;
			
		while(true) {
			boolean flag = false;
			
			// 1. 현재 위치 청소
			if(map[r][c] == 0) {
				map[r][c] = 2;
				ans++;
			}
			
			for(int k=0; k<4; k++) {
				
				// 탐색할 왼쪽 방향
				if(d == 0) tmp = 3;
				else tmp--;	
				
				// 다음 위치
				int nx = r + dx[tmp];
				int ny = c + dy[tmp];
				
				// 청소 공간 없으면
				if(map[nx][ny] != 0) {
					d = tmp; // 회전 저장
					continue;
				}
				
				r = nx; c = ny; 
				d = tmp;
				
				// 1번으로 돌아가
				flag = true;
				break;
			}
			
			if(flag) continue;
			
			// 후진
			int nx = r - dx[d];
			int ny = c - dy[d];
			
			// 벽
			if(map[nx][ny] == 1) {
				break;
			}
			
			r = nx; 
			c = ny;
			
		}
		System.out.println(ans);
	}

}
