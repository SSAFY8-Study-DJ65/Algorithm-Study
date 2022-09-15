import java.io.*;
import java.util.*;

public class Main {
	
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int R, C, wolf, sheep, answ, anss;
	static char[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		
		v = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
//		for(int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		for(int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sheep = 0;
				wolf = 0;
				if(map[i][j] != '#') dfs(i, j);
				
				if(sheep > wolf) anss = anss + sheep;
				else answ = answ + wolf;
				
			}
		}
		System.out.println(anss + " " + answ);
	}

	public static void dfs(int i, int j) {
		if(map[i][j] == 'v') wolf++;
		else if(map[i][j] == 'o') sheep++; 
		
		map[i][j] = '#';
		
		for(int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			
			if(0 <= ni && ni < R && 0 <= nj && nj < C && map[ni][nj] != '#') {
				dfs(ni, nj);
			}
		}
	}
}
