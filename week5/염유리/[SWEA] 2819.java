import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][] map;
	static HashSet<String> set;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			
			map = new int[4][4];
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			set = new HashSet<>();
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i, j, 0, "");
				}
			}
			
			System.out.println("#" + t + " " + set.size());
		}

	}
	
	public static void dfs(int x, int y, int cnt, String st) {
		
		if(cnt == 7) {
			set.add(st);
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			
			dfs(nx, ny, cnt+1, st + map[x][y]);
		}
	}

}
