package boj.n2564;

// S1 경비원
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int r = sc.nextInt();
		
		int n = sc.nextInt();
		
		int[][] board = new int[r+1][c+1];
		
		int[][] point = new int[n+1][2];
		
		for(int i=0; i<=n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(x == 1) { // 북
				point[i][0] = 0;
				point[i][1] = y;
			}else if(x == 2) { // 남
				point[i][0] = r;
				point[i][1] = y;
			}else if(x == 3) { // 서
				point[i][0] = y;
				point[i][1] = 0;
			}else if(x == 4) { // 동
				point[i][0] = y;
				point[i][1] = c;
			}
		}
		
		int dgx = point[n][0];
		int dgy = point[n][1];
		
		int dist = 0;
		
		if(dgx == 0 || dgx == r) {
			for(int i=0; i<n; i++) {
				
				if(Math.abs(point[i][0] - dgx) == 0) { // 5 8 vs 5 3 
					dist += Math.abs(point[i][1] - dgy);
				}
				else if(Math.abs(point[i][0] - dgx) == r) { // 0 4 vs 5 3
					
					dist += Math.min(r+point[i][1]+dgy, r+(c-point[i][1])+(c-dgy));
				}
				else { // 2 0 vs 5 3
					dist += Math.abs(point[i][0]-dgx) + Math.abs(point[i][1]-dgy);
				}
			}
		}else {
			for(int i=0; i<n; i++) {
				
				if(Math.abs(point[i][1] - dgy) == 0) { // 5 8 vs 5 3 
					dist += Math.abs(point[i][0] - dgx);
				}
				else if(Math.abs(point[i][1] - dgy) == c) { // 0 4 vs 5 3
					
					dist += Math.min(c+point[i][0]+dgx, c+(r-point[i][0])+(r-dgx));
				}
				else { // 2 0 vs 5 3
					dist += Math.abs(point[i][1]-dgy) + Math.abs(point[i][0]-dgx);
				}
			}
		}
		
		System.out.println(dist);
		
		
	}

}
