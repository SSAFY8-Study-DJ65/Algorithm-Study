import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * BOJ 21608 G5 상어 초등학교
 */
public class Main {

	static int[][] map;
	static int N; 
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static class Seat implements Comparable<Seat>{
		int r;
		int c;
		int fav;
		int empty;
		
		
		public Seat(int r, int c, int fav, int empty) {
			this.r = r;
			this.c = c;
			this.fav = fav;
			this.empty = empty;
		}


		@Override
		public String toString() {
			return "Seat [r=" + r + ", c=" + c + ", fav=" + fav + ", empty=" + empty + "]";
		}


		@Override
		public int compareTo(Seat o) {
			if(this.fav == o.fav) {
				if(this.empty == o.empty) {
					if(this.r == o.r) {
						return this.c - o.c;
					}
					return this.r - o.r;
				}
				return o.empty - this.empty;
			}
			return o.fav - this.fav;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		map = new int[N][N];
		
		ArrayList[] favList = new ArrayList[N*N+1];
		
		
		for(int k=0; k<N*N; k++) {
			
			// 학생을 입력받으면서
			int idx = sc.nextInt();
			
			favList[idx] = new ArrayList<Integer>();
			
			for(int i=0; i<4; i++) {
				favList[idx].add(sc.nextInt());
			}
			
			// map을 돌아다니면서 좋은 자리를 찾아
			
			// 1,2,3 조건은 compare로 만들어놨으니
			// 어디다 담아서 비교해줄 수 있으면 됨
			PriorityQueue<Seat> seats = new PriorityQueue<>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] != 0) continue;
					
					seats.add(findSeat(favList[idx], i, j));
				}
			}
			
			// pq에서 뽑은 첫번째 자리가 idx 자리
			Seat choice = seats.poll();
			map[choice.r][choice.c] = idx;
		}
		
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				int st = map[i][j];
				
				int favnum = satisfy(favList[st], i, j);
				
				if(favnum == 0) continue;
				ans += Math.pow(10, favnum-1);
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static Seat findSeat(ArrayList<Integer> favs, int x, int y) {
	
		Seat seat = new Seat(x, y, 0, 0);
		
		// 인접에 좋아하는애 몇명, 빈자리 몇개
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if(favs.contains(map[nx][ny])) {
				seat.fav++;
			}
			else if(map[nx][ny] == 0) {
				seat.empty++;
			}
		}
		
		return seat;
	}
	
	public static int satisfy(ArrayList<Integer> favs, int x, int y) {
		
		int sum = 0;
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if(favs.contains(map[nx][ny])) {
				sum++;
			}
		}
		
		return sum;
	}

}
