package G3;

import java.io.*;
import java.util.*;

public class G31600 {

	static class Point {
		int i, j, k;

		public Point(int i, int j, int z) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
	}

	static int K, W, H, min;
	static int map[][];
	static int[] hdi = { 1, 2, -2, -1, 2, 1, -1, -2 };
	static int[] hdj = { 2, 1, 1, 2, -1, -2, -2, -1 };
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[][][] dist;
	static boolean[][][] v;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		v = new boolean[H][W][K + 1];
		dist = new int[H][W][K + 1];

		min = -1;
		int cnt = 0;
		
		System.out.println(bfs());
    
    }
  
  	public static int bfs() {
		int cnt = 0;
		Queue<Point> q = new ArrayDeque<Point>();
		q.add(new Point(0,0,0));
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- != 0) {
				Point p = q.poll();
				
				if(p.i == H-1 && p.j == W-1) return cnt;
				
				for(int i=0;i<4;i++) {
					int ni = p.i + di[i];
					int nj = p.j + dj[i];
					
					if(ni >= 0 && ni < H && nj >= 0 && nj < W && !v[ni][nj][p.k] && map[ni][nj] != 1) {
						v[ni][nj][p.k] = true;
						q.add(new Point(ni, nj, p.k));
					}
				}
				
				if(p.k+1 <= K) {
					for(int i=0;i<8;i++) {
						int ni = p.i + hdi[i]; 
						int nj = p.j + hdj[i];
						if(ni >= 0 && ni < H && nj >= 0 && nj < W && !v[ni][nj][p.k+1] && map[ni][nj] != 1) {
							v[ni][nj][p.k+1] = true;
							q.add(new Point(ni, nj, p.k+1));
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}

}
