import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 안전 영역
 */
public class Main {

	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(map[i][j], max);
			}
		}
		
		int ans = 0;
		for(int k=0; k<=max; k++) {
			int[][] temp = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			// 비가 k일때 잠기기
			rain(temp, k);
			
			// 안전영역 개수 구하기
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j] < 0 || visited[i][j]) continue;
					safe(temp, i, j);
					cnt++;
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
		
	}
	
	public static void rain(int[][] tmap, int k) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tmap[i][j] <= k) {
					tmap[i][j] *= -1;
				}
			}
		}
	}
	
	public static void safe(int[][] tmap, int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny]) continue;
				if(tmap[nx][ny] < 0) continue;
				
				visited[nx][ny] = true;
				queue.offer(new Point(nx, ny));
			}
		}
	}

}
