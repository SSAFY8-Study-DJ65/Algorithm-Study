import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1, 0};
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1, 0};
	
	static char[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		
		for(int i=0; i<8; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		// 시작 : 7,0  도착 : 0,7
			
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(new Point(7, 0));
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
			
				Point p = queue.poll();
				
				if(map[p.x][p.y] == '#') continue;
				
				for(int d=0; d<9; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					
					if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
					
					if(nx == 0 && ny == 7) {
						System.out.println(1);
						return;
					}
					if(map[nx][ny] == '#') continue;
					
					queue.offer(new Point(nx, ny));
				}
			}
			// 벽 이동
			moveWalls();
		}
		System.out.println(0);
	}
	
	public static void moveWalls() {
		
		for(int i=6; i>=0; i--) {
			for(int j=0; j<8; j++) {
				 map[i+1][j] = map[i][j];
			}
		}
		
		for(int j=0; j<8; j++) {
			map[0][j] = '.';
		}

	}
}
