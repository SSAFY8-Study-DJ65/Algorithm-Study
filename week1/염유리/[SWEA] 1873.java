
// D3 상호의 배틀필드
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int r, c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			r = sc.nextInt();
			c = sc.nextInt();
			
			char[][] map = new char[r][c];
			
			int tankx = -1;
			int tanky = -1;
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1}; 
			int d = -1;
			
			for(int i=0; i<r; i++) {
				String line = sc.next();
				for(int j=0; j<c; j++) {
					map[i][j] = line.charAt(j);
					
					if(map[i][j] == '^') {
						d = 0;
						tankx = i;
						tanky = j;
						map[i][j] = '.';
					}else if(map[i][j] == 'v' ) {
						d = 1;
						tankx = i;
						tanky = j;
						map[i][j] = '.';
					}else if(map[i][j] == '<') {
						d = 2;
						tankx = i;
						tanky = j;
						map[i][j] = '.';
					}else if(map[i][j] == '>') {
						d = 3;
						tankx = i;
						tanky = j;
						map[i][j] = '.';
					}
				}
			}
			
			int n = sc.nextInt();
			String input = sc.next();
			
			for(int k=0; k<n; k++) {
				char move = input.charAt(k);
				
				if(move == 'S') {
					int bombx = tankx + dx[d];
					int bomby = tanky + dy[d];
					
					while(check(bombx, bomby)) {
						
						if(map[bombx][bomby] == '*') {
							map[bombx][bomby] = '.';
							break;
						}
						else if(map[bombx][bomby] == '#') {
							break;
						}
						
						bombx += dx[d];
						bomby += dy[d];
					}
					
				} else {
				
					if(move == 'U') d = 0;
					else if(move == 'D') d = 1;
					else if(move == 'L') d = 2;
					else if(move == 'R') d = 3;
					
					if(!check(tankx+dx[d], tanky+dy[d])) continue;
					
					if(map[tankx + dx[d]][tanky + dy[d]] == '.') {
						tankx += dx[d];
						tanky += dy[d];
					}
				}
			}
			
			if(d == 0) {
				map[tankx][tanky] = '^';
			}else if(d == 1) {
				map[tankx][tanky] = 'v';
			}else if(d == 2) {
				map[tankx][tanky] = '<';
			}else if(d == 3) {
				map[tankx][tanky] = '>';
			}
			
			System.out.print("#" + t + " ");
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}
	
	public static boolean check(int x, int y) {
		if(x < 0 || x >= r || y < 0 || y >= c) {
			return false;
		}
		return true;
	}

}
