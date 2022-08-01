import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SWEA_1873 { // 배틀필드

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int h = sc.nextInt();
			int w = sc.nextInt();
			int x = -1;
			int y = -1;
			char[][] m = new char[h][w]; 
			int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			char[] udlr = {'^', 'v', '<', '>'};
			int idx = -1;
			for (int i = 0; i < h; i++) {
				String s = sc.next(); 
				for (int j = 0; j < w; j++) {
					m[i][j] = s.charAt(j);
					for (int k = 0; k < 4; k++) {
						if(m[i][j] == udlr[k])
						{
							x = i;
							y = j;
							idx = k;
						}
					}
				}
			}
			int n = sc.nextInt();
			String s = sc.next();
			for (int i = 0; i < n; i++) {
				char input = s.charAt(i);
				if(input == 'U') idx = 0;
				else if(input == 'D') idx = 1;
				else if(input == 'L') idx = 2;
				else if(input == 'R') idx = 3;
				
				if(input != 'S')
				{
					m[x][y] = udlr[idx];
					int nx = x + d[idx][0];
					int ny = y + d[idx][1];
					
					if(!(nx<0||nx>=h||ny<0||ny>=w)&&m[nx][ny]=='.'&&m[nx][ny]!='-')
					{
						m[x][y] = '.';
						x = nx;
						y = ny;
						m[x][y] = udlr[idx];
					}
				}
				else // input == 'S'
				{
					int nx = x;
					int ny = y;
					while(true)
					{
						nx += d[idx][0];
						ny += d[idx][1];
						if(nx<0||nx>=h||ny<0||ny>=w||m[nx][ny]=='#') break;
						else if(m[nx][ny]=='*') {
							m[nx][ny] = '.';
							break;
						}
					}
				}
			}
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(m[i][j]);
				}
				System.out.println();
			}
		}
	}
}
