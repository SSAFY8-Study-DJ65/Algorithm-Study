import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw5653 {

	static class bacteria {
		// 0: 빈공간, 1:비활성, 2:활성, 3:쥬금
		int status;
		int cnt, lt;
	}

	// ↑ ↓ ← →
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static bacteria[][][] map = new bacteria[2][352][352];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 352; i++)
				for (int j = 0; j < 352; j++) {
					map[0][i][j] = new bacteria();
					map[1][i][j] = new bacteria();
					map[0][i][j].status = 0;
					map[1][i][j].status = 0;
				}

			for (int i = K / 2; i < N + (K / 2); i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = K / 2; j < M + (K / 2); j++) {
					map[0][i][j].cnt = Integer.parseInt(st.nextToken());
					if (map[0][i][j].cnt > 0) {
						map[0][i][j].status = 1;
						map[0][i][j].lt = 0;
					}
				}
			}

			int tempn = N + K + 2;
			int tempm = M + K + 2;

			int cur = 0;
			for (int k = 0; k < K; k++) {
				for (int i = 0; i < tempn; i++)
					for (int j = 0; j < tempm; j++) {
						if (map[cur][i][j].status == 3) {
							map[1 - cur][i][j].status = map[cur][i][j].status;
							continue;
						}

						else if (map[cur][i][j].status == 1) {
							map[1 - cur][i][j].lt = map[cur][i][j].lt + 1;
							map[1 - cur][i][j].cnt = map[cur][i][j].cnt;

							if (map[1 - cur][i][j].lt == map[1 - cur][i][j].cnt)
								map[1 - cur][i][j].status = 2;

							else
								map[1 - cur][i][j].status = 1;
						} else if (map[cur][i][j].status == 2) {
							if (map[cur][i][j].lt == map[cur][i][j].cnt) {
								for (int d = 0; d < 4; d++) {
									int ni = i + di[d];
									int nj = j + dj[d];

									if (map[cur][ni][nj].status == 0) {
										if (map[1 - cur][ni][nj].status == 0) {
											map[1 - cur][ni][nj].status = 1;
											map[1 - cur][ni][nj].cnt = map[cur][i][j].cnt;
											map[1 - cur][ni][nj].lt = 0;
										} else if (map[1 - cur][i][j].status == 1
												&& map[1-cur][ni][nj].cnt < map[cur][i][j].cnt)
											map[1 - cur][ni][nj].cnt = map[cur][i][j].cnt;
									}
								}
							}
							map[1 - cur][i][j].lt = map[cur][i][j].lt - 1;
							if (map[1 - cur][i][j].lt == 0)
								map[1 - cur][i][j].status = 3;
							else
								map[1 - cur][i][j].status = 2;
						}
					}
				cur = 1 - cur;
			}
			int ans = 0;
			for (int i = 0; i < tempn; i++)
				for (int j = 0; j < tempm; j++) {
					if (map[cur][i][j].status == 1 || map[cur][i][j].status == 2)
						ans++;
				}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
