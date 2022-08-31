import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, L, R, sum, cnt, day;
	static boolean flag;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		day = 0;
		visited = new boolean[N][N];
		while(true) {
			
			flag = false;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue;
					
					bfs(i, j);
				}
			}
			
			if(!flag) break;
			
			day++;
		}
			
		System.out.println(day);
		
	}
	
	public static void bfs(int x, int y) {
		
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(x, y));
		visited[x][y] = true;		
		sum = map[x][y];
		cnt = 1;
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny]) continue;
				if(Math.abs(map[p.x][p.y] - map[nx][ny]) >= L && Math.abs(map[p.x][p.y] - map[nx][ny]) <= R) {
					flag = true;
					visited[nx][ny] = true;
					queue.offer(new Point(nx, ny));
					sum += map[nx][ny];
					cnt++;
					list.add(new Point(nx, ny));
				}
			}
		}
		
		if(cnt > 0) {
			for(int i=0; i<list.size(); i++) {
				map[list.get(i).x][list.get(i).y] = sum / list.size();
			}
		}
	}
}
