import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * G4 마법사 상어와 파이어스톰
 */
public class Main {

	static int N, Q, len;
	static int[] L;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 2^N x 2^N
		Q = sc.nextInt(); // 파이어스톰 횟수
		
		len = (int)Math.pow(2, N);
		map = new int[len][len];
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		L = new int[Q]; // 시전한 단계
		for(int i=0; i<Q; i++) {
			L[i] = sc.nextInt();
		}
		
		for(int k=0; k<Q; k++) {
			int l = (int) Math.pow(2, L[k]);
			
			int[][] temp = new int[len][len];
			
			for(int i=0; i<len; i += l) {
				for(int j=0; j<len; j += l) {
					
					// 시계방향 회전
					temp = compute3(temp, i, j, l);
				}
			}
			map = temp;
			
			map = checkIce();
		}
		
		int sum = 0;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		
		int max = 0;
		visited = new boolean[len][len];
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;
				
				max = Math.max(max, bfs(i, j));
			}
		}
		System.out.println(max);
	}
	
	public static int bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new Point(x, y));
		int area = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
				if(visited[nx][ny]) continue;
				if(map[nx][ny] == 0) continue;
				
				queue.offer(new Point(nx, ny));
				visited[nx][ny] = true;
				area++;
			}
		}
		return area;
	}
	
	public static int[][] checkIce() {

		int[][] arr = new int[len][len];
		for(int p=0; p<len; p++) {
			for(int q=0; q<len; q++) {
				arr[p][q] = map[p][q];
			}
		}
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				int cnt = 0;
				
				for(int d=0; d<4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(nx < 0 || nx >= len || ny < 0 || ny >= len) continue;
					
					if(map[nx][ny] > 0) cnt++;
				}
				
				if(cnt < 3 && map[i][j] > 0) arr[i][j]--;
			}
		}
		
		return arr;
	}
	
	// 오른쪽 90도 회전
	public static int[][] compute3(int[][] temp, int r, int c, int s) {
		
		for(int i=0; i<s; i++) {
			for(int j=0; j<s; j++) {
				temp[r+i][c+j] = map[r+s-1-j][c+i];
			}
		}
		
		return temp;
	}
}
