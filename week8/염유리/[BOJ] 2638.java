import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * G3 치즈
 */
public class Main {

	static int N, M, outside;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while(true) {
			visited = new boolean[N][M];
			// 바깥부터 테두리를 찾아가면서 +1
			// 2변 이상이라면 3 이상일 것.
			
			int[][] temp = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			bfs(0, 0, temp);
			
			// 3 이상 없애고
			// 더 녹을게 있는지 체크
			boolean flag = false;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(temp[i][j] >= 3) {
						map[i][j] = 0;
						flag= true;
					}
				}
			}
			
			if(!flag) break;
			
			time++;
		}
		System.out.println(time);

	}
	
	public static void bfs(int x, int y, int[][] map) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(map[nx][ny] >= 1) {
					map[nx][ny] += 1;
					continue;
				}
				if(visited[nx][ny] && map[nx][ny] == 0) {
					continue;
				}
				
				visited[nx][ny] = true;
				queue.offer(new Point(nx, ny));
			}
		}
		
	}
}
