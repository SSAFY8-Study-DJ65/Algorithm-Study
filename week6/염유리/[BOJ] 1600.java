import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BOJ 1600 G3 말이 되고픈 원숭이
 */
public class Main {

	static int K, W, H;
	static int[][] map; 
	static boolean[][][] visited;

	// 말 이동범위
	static int[] hdx = {1,2,2,1,-1,-2,-2,-1};
	static int[] hdy = {2,1,-1,-2,-2,-1,1,2};

	// 원숭이 이동범위
	static int[] mdx = { -1, 1, 0, 0 };
	static int[] mdy = { 0, 0, -1, 1 };

	static class Monkey {
		int x;
		int y;
		int k;
		int cnt;

		public Monkey(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[W][H];
		visited = new boolean[W][H][K+1];
		
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < H; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 원숭이 0,0에서 시작 w-1, h-1에 도착
		System.out.println(bfs());
		
	}

	private static int bfs() {
		Queue<Monkey> queue = new LinkedList<>();
		
		queue.offer(new Monkey(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Monkey m = queue.poll();
			
			if(m.x == W-1 && m.y == H-1) {
				return m.cnt;
			}
			
			for(int d=0; d<4; d++) {
				int nx = m.x + mdx[d];
				int ny = m.y + mdy[d];
				
				if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
				if(visited[nx][ny][m.k]) continue;
				if(map[nx][ny] == 1) continue;
				
				queue.offer(new Monkey(nx, ny, m.k, m.cnt+1));
				visited[nx][ny][m.k] = true;
			}
			
			if(m.k < K) { // 말
				for(int d=0; d<8; d++) {
					int nx = m.x + hdx[d];
					int ny = m.y + hdy[d];
					
					if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
					if(visited[nx][ny][m.k+1]) continue;
					if(map[nx][ny] == 1) continue;
					
					queue.offer(new Monkey(nx, ny, m.k+1, m.cnt+1));
					visited[nx][ny][m.k+1] = true;
				}
			}
			
		}
		return -1;
	}
	
}
