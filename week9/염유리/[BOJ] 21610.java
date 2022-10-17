import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * G5 마법사 상어와 비바라기
 */
public class Main {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(N, 1));
		queue.offer(new Point(N, 2));
		queue.offer(new Point(N-1, 1));
		queue.offer(new Point(N-1, 2));
		
		int[] d = new int[M];
		int[] s = new int[M];
		for(int i=0; i<M; i++) {
			d[i] = sc.nextInt();
			s[i] = sc.nextInt();
		}
		
		boolean[][] remove = new boolean[N+1][N+1];
		
		// 방향 8개. 1부터
		int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
		int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
		
		for(int m=0; m<M; m++) {
			remove = new boolean[N+1][N+1];
			// m번째 이동
			// 첫번째 줄과 N번째 줄 연결
			// 구름이 d[m]방향으로 s[m]칸 이동
			for(int q=0; q<queue.size(); q++) {
				Point p = queue.poll();
				
				p.x = p.x + dx[d[m]] * s[m];
				p.y = p.y + dy[d[m]] * s[m];
			
				// N 5
				// 4 1 => 4 3
				// 4 2 => 4 4
				while(p.x <= 0 || p.x > N) {
					if(p.x > N) p.x %= N;
					else if(p.x == 0) p.x = N;
					else if(p.x < 0) p.x = N + p.x;
				}
				
				while(p.y <= 0 || p.y > N) {
					if(p.y > N) p.y %= N;
					else if(p.y == 0) p.y = N;
					else if(p.y < 0) p.y = N + p.y;
				}
				
				// 다시 offer
				queue.offer(p);
			}
			
			// queue poll하면서 물 1 증가, 칸 저장
			for(int q=0; q<queue.size(); q++) {
				Point p = queue.poll();
				
				map[p.x][p.y] += 1;
				
				queue.offer(p);
				// 구름이 모두 사라진다
				remove[p.x][p.y] = true;
			}
			
			// 대각선으로 물이 있는 수만큼 증가
			// 범위 내에서만
			int[] cx = {-1, -1, 1, 1};
			int[] cy = {-1, 1, -1, 1};
			
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				
				int cnt = 0;
				
				// 대각선 4개
				for(int k=0; k<4; k++) {
					int nx = p.x + cx[k];
					int ny = p.y + cy[k];
					
					if(nx <= 0 || nx > N || ny <= 0 || ny > N) continue;
					
					if(map[nx][ny] > 0) cnt++;
				}	
				
				map[p.x][p.y] += cnt;
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] >= 2 && !remove[i][j]) {
						queue.offer(new Point(i, j));
						map[i][j] -= 2;
					}
				}
			}
		}
		
		int sum = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

}
