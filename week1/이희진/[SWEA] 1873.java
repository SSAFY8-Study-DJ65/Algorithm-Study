import java.util.Scanner;

public class d31873 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 상, 하, 좌, 우
		int[] x = { -1, 1, 0, 0 };
		int[] y = { 0, 1, -1, 1 };

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();

			char[][] map = new char[H][W];

			// 맵 입력
			int dx = 0;
			int dy = 0;

			for (int j = 0; j < H; j++) {
				String str = sc.next();
				for (int k = 0; k < W; k++) {
					map[j][k] = str.charAt(k);
					if (map[j][k] == '<' || map[j][k] == '>' || map[j][k] == '^' || map[j][k] == 'v') {
						dx = j;
						dy = k;
					}
				}
			}

			int N = sc.nextInt();
			String str = sc.next();

			for (int j = 0; j < N; j++) {

				// 이동
				if (str.charAt(j) == 'U') { // 상
					if (dx - 1 >= 0 && map[dx - 1][dy] == '.') {
						map[dx--][dy] = '.';
						map[dx][dy] = '^';
					} else
						map[dx][dy] = '^';
				} else if (str.charAt(j) == 'D') { // 하
					if (dx + 1 < H && map[dx + 1][dy] == '.') {
						map[dx++][dy] = '.';
						map[dx][dy] = 'v';
					} else
						map[dx][dy] = 'v';
				} else if (str.charAt(j) == 'L') { // 좌
					if (dy - 1 >= 0 && map[dx][dy - 1] == '.') {
						map[dx][dy--] = '.';
						map[dx][dy] = '<';
					} else
						map[dx][dy] = '<';
				} else if (str.charAt(j) == 'R') { // 우
					if (dy + 1 < W && map[dx][dy + 1] == '.') {
						map[dx][dy++] = '.';
						map[dx][dy] = '>';
					} else
						map[dx][dy] = '>';
				}

				// 슛
				else if (str.charAt(j) == 'S') {
					int ax = dx;
					int ay = dy;
					boolean check = true; //벽 체크
					
					if (map[dx][dy] == '^') {
						while (ax-1 >= 0 && map[--ax][ay] != '*') {
							if(map[ax][ay] == '#') {
								check = false;
								break;
							} 
						}
						if(dx == 0) check = false;
						else if(ax == 0 && map[ax][ay] == '-') check = false;
					} else if (map[dx][dy] == 'v') {
						while (ax+1 < H && map[++ax][ay] != '*') {
							if(map[ax][ay] == '#')  {
								check = false;
								break;
							} 
						}
						System.out.println(ax);
						if(dx == H-1) check = false;
						else if(ax == H-1 && map[ax][ay] == '-') check = false;
					} else if (map[dx][dy] == '<') {
						while (ay-1 >= 0 && map[ax][--ay] != '*') {
							if(map[ax][ay] == '#')  {
								check = false;
								break;
							}
						}
						if(dy == 0) check = false;
						else if(ay == 00 && map[ax][ay] == '-') check = false;
					} else if (map[dx][dy] == '>') {
						while (ay+1 < W && map[ax][++ay] != '*') {
							if(map[ax][ay] == '#')  {
								check = false;
								break;
							}
						}
						if(dy == W-1) check = false;
						else if(ay == W-1 && map[ax][ay] == '-') check = false;
					}
					if (check) {
						map[ax][ay] = '.';
					}
				}

			}

			// 출력
			System.out.print("#"+i+" ");
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					System.out.print(map[j][k]);
				}
				System.out.println();
			}
		}
	}
}
