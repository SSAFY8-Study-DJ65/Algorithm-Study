import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N, M, K;
	static int s1 = 700, s2= 700;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Cell> pq;
	static Queue<Cell> queue;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Cell implements Comparable<Cell>{
		int x;
		int y;
		int power;
		int now;
		int death;
		
		Cell(int x, int y, int power, int now, int death){
			this.x = x;
			this.y = y;
			this.power = power;
			this.now = now;
			this.death = death;
		}

		@Override
		public int compareTo(Cell o) {
			return -(this.power - o.power);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			// 생명력을 저장
			map = new int[s1][s2];
			// 죽는 시간을 저장
			//copymap = new int[s1][s2];
			
			queue = new LinkedList<>();
			pq = new PriorityQueue<>();
			visited = new boolean[s1][s2];
				
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int num = sc.nextInt();
					if(num > 0) {
						visited[i+s1/2-1][j+s1/2-1] = true;
						map[i+s1/2-1][j+s1/2-1] = num;
						queue.add(new Cell(i+s1/2-1, j+s1/2-1, num, num, num*2));
					}
				}
			}
			
			for(int k=1; k<=K; k++) {
				int qsize = queue.size();
				
				for(int i=0; i<qsize; i++) {
					Cell cell = queue.poll();
					
					if(cell.now >= k) {
						queue.add(cell);
					}else if(cell.now+1 == k) {
						pq.add(cell);
					}else if(cell.now < k && k < cell.death) {
						queue.add(cell);
					}
				}
				
				bfs(k);
			}
			
			System.out.println("#" + t + " " + queue.size());
		}
	}

	private static void bfs(int k) {
		while(!pq.isEmpty()) {
			Cell p = pq.poll();
			
			if(k < p.death) {
				queue.add(p);
			}
			
			for(int d=0; d<4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if(nx < 0 || nx >= s1 || ny < 0 || ny >= s2) continue;
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				map[nx][ny] = p.power;
				queue.add(new Cell(nx, ny, p.power, p.power+k, p.power*2+k));
			}
		}
	}
}
