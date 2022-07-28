import java.util.Scanner;
/*
 * SWEA 1873 상호의 배틀필드
 */
public class SWEA_01873 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			// ↑/→/↓/←
			int[] dx = {-1, 0, 1, 0};
			int[] dy = {0, 1, 0, -1};
			int mode = 0;
			
			int x = 0;
			int y = 0;
			
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String tmp = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j]  == '^') {
						mode = 0;
						x = i; y = j;
					} else if (map[i][j] == '>') {
						mode = 1;
						x = i; y = j;
					} else if (map[i][j] == 'v') {
						mode = 2;
						x = i; y = j;
					} else if (map[i][j] == '<') {
						mode = 3;
						x = i; y = j;
					}
				}
			}
			
			int N = sc.nextInt();
			String command = sc.next();
			
			for (int i = 0; i < N; i++) {
				char com = command.charAt(i);
				
				if (com == 'U') {
					mode = 0;
					map[x][y] = '^';
					if (x+dx[mode] >= 0 && x+dx[mode] < H && map[x+dx[mode]][y+dy[mode]] == '.') {
						map[x][y] = '.';
						x += dx[mode];
						y += dy[mode];
						map[x][y] = '^';
					}
				} else if (com == 'R') {
					mode = 1;
					map[x][y] = '>';
					if (y+dy[mode] >= 0 && y+dy[mode] < W && map[x+dx[mode]][y+dy[mode]] == '.') {
						map[x][y] = '.';
						x += dx[mode];
						y += dy[mode];
						map[x][y] = '>';
					}
				} else if (com == 'D') {
					mode = 2;
					map[x][y] = 'v';
					if (x+dx[mode] >= 0 && x+dx[mode] < H && map[x+dx[mode]][y+dy[mode]] == '.') {
						map[x][y] = '.';
						x += dx[mode];
						y += dy[mode];
						map[x][y] = 'v';
					}
				} else if (com == 'L') {
					mode = 3;
					map[x][y] = '<';
					if (y+dy[mode] >= 0 && y+dy[mode] < W && map[x+dx[mode]][y+dy[mode]] == '.') {
						map[x][y] = '.';
						x += dx[mode];
						y += dy[mode];
						map[x][y] = '<';
					}
				} else if (com == 'S') {
					int nx = x+dx[mode];
					int ny = y+dy[mode];
					while (nx >= 0 && nx < H && ny >= 0 && ny < W) {
						if (map[nx][ny] == '*' || map[nx][ny] == '#') {
							if (map[nx][ny] == '*') {
								map[nx][ny] = '.';
							}
							break;
						}
						nx += dx[mode];
						ny += dy[mode];
					}
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
