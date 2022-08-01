import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_4615 { // 재미있는 오셀로 게임

	public static void main(String args[]) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int[][] map = new int[n][n]; // 초기값: 0
			
			// 초기 셋팅
			map[(n/2)-1][(n/2)-1] = 2; // 백돌
			map[(n/2)][(n/2)-1] = 1; // 흑돌
			map[(n/2)-1][(n/2)] = 1;
			map[(n/2)][(n/2)] = 2;
			
			int[][] d = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}}; // 8방향
			int m = sc.nextInt();
			for (int i = 0; i < m; i++)
			{
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				int c = sc.nextInt(); // 돌 색깔
				map[x][y] = c;
				
				for (int j = 0; j < 8; j++) { // 8방향 탐색
					int nx = x+d[j][0];
					int ny = y+d[j][1];
					int cnt = 0; // 반대편이 닫혀있다면 뒤집을 수 있는 적의 돌 수
					while(true)
					{
						if(nx<0||nx>=n) break;
						else if(ny<0||ny>=n) break;
						else if(map[nx][ny] == 0) break;
						else if(map[nx][ny] == c)
						{
							if(cnt == 0) break; // 내 돌 사이에 적의 돌이 없으면 break;
							else
							{	
								int px = nx+(d[j][0]*-1);
								int py = ny+(d[j][1]*-1);
								for (int k = 0; k < cnt; k++) {
									map[px][py] = c; // 적의 돌을 내돌로 바꿈
									px += d[j][0]*-1;
									py += d[j][1]*-1;
								}
								break;
							}
						}
						// 탐색하는 돌이 적의 돌 일 경우만 진행
						cnt++;
						nx += d[j][0];
						ny += d[j][1];
					}
				}
			}
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] == 1) cnt1++;
					else if(map[i][j] == 2) cnt2++;
				}
			}
			System.out.printf("#%d %d %d\n", test_case, cnt1, cnt2);
		}
	}
}
