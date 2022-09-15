package SWEA;

import java.io.*;
import java.util.*;

public class D46109 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);

//			System.out.println(dir);

			int[][] map = new int[N][N];
			boolean[][] v = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			switch (dir) {
			case 'u':
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int sel = map[i][j];
						if (sel == 0)
							continue;
						int cnt = 1;
						while (true) {
							if ((i + cnt) >= N || v[i][j] || v[i + cnt][j]) {
								break;
							}

							if (map[i + cnt][j] != 0 && map[i + cnt][j] != sel) {
								v[i][j] = true;
								break;
							}

							if (map[i + cnt][j] == sel) {
								v[i][j] = true;
								v[i + cnt][j] = true;
								map[i][j] = sel * 2;
								map[i + cnt][j] = 0;
								break;
							}

							if (map[i + cnt][j] == 0) {
								v[i + cnt][j] = true;
								cnt++;
							}
						}
					}
				}

//				for(int[] a : map) System.out.println(Arrays.toString(a)); 

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int cnt = 1;
						if (map[i][j] == 0) {
							while (true) {
								if (i + cnt >= N)
									break;

								if (map[i + cnt][j] != 0) {
									map[i][j] = map[i + cnt][j];
									map[i + cnt][j] = 0;
									break;
								}

								if (map[i + cnt][j] == 0) {
									cnt++;
								}
							}
						} else
							continue;
					}
				}
				break;

			case 'd':
				for (int i = N - 1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						int sel = map[i][j];
						if (sel == 0)
							continue;
						int cnt = 1;
						while (true) {
							if ((i - cnt) < 0 || v[i][j] || v[i - cnt][j]) {
								break;
							}

							if (map[i - cnt][j] != 0 && map[i - cnt][j] != sel) {
								v[i][j] = true;
								break;
							}

							if (map[i - cnt][j] == sel) {
								v[i][j] = true;
								v[i - cnt][j] = true;
								map[i][j] = sel * 2;
								map[i - cnt][j] = 0;
								break;
							}

							if (map[i - cnt][j] == 0) {
								v[i - cnt][j] = true;
								cnt++;
							}
						}
					}
				}

//				for(int[] a : map) System.out.println(Arrays.toString(a)); 

				for (int i = N - 1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						int cnt = 1;
						if (map[i][j] == 0) {
							while (true) {
								if (i - cnt < 0)
									break;

								if (map[i - cnt][j] != 0) {
									map[i][j] = map[i - cnt][j];
									map[i - cnt][j] = 0;
									break;
								}

								if (map[i - cnt][j] == 0) {
									cnt++;
								}
							}
						} else
							continue;
					}
				}
				break;

			case 'r':
				for (int i = N - 1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						int sel = map[j][i];
						if (sel == 0)
							continue;
						int cnt = 1;
						while (true) {
							if ((i - cnt) < 0 || v[j][i] || v[j][i - cnt]) {
								break;
							}

							if (map[j][i - cnt] != 0 && map[j][i - cnt] != sel) {
								v[j][i] = true;
								break;
							}

							if (map[j][i - cnt] == sel) {
								v[j][i] = true;
								v[j][i - cnt] = true;
								map[j][i] = sel * 2;
								map[j][i - cnt] = 0;
								break;
							}

							if (map[j][i - cnt] == 0) {
								v[j][i - cnt] = true;
								cnt++;
							}
						}
					}
				}

//				for(int[] a : map) System.out.println(Arrays.toString(a)); 

				for (int i = N - 1; i > 0; i--) {
					for (int j = 0; j < N; j++) {
						int cnt = 1;
						if (map[j][i] == 0) {
							while (true) {
								if (i - cnt < 0)
									break;

								if (map[j][i - cnt] != 0) {
									map[j][i] = map[j][i - cnt];
									map[j][i - cnt] = 0;
									break;
								}

								if (map[j][i - cnt] == 0) {
									cnt++;
								}
							}
						} else
							continue;
					}
				}
				break;

			case 'l':
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int sel = map[j][i];
						if (sel == 0)
							continue;
						int cnt = 1;
						while (true) {
							if ((i + cnt) >= N || v[j][i] || v[j][i + cnt]) {
								break;
							}

							if (map[j][i + cnt] != 0 && map[j][i + cnt] != sel) {
								v[j][i] = true;
								break;
							}

							if (map[j][i + cnt] == sel) {
								v[j][i] = true;
								v[j][i + cnt] = true;
								map[j][i] = sel * 2;
								map[j][i + cnt] = 0;
								break;
							}

							if (map[j][i + cnt] == 0) {
								v[j][i + cnt] = true;
								cnt++;
							}
						}
					}
				}

//				for(int[] a : map) System.out.println(Arrays.toString(a)); 

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int cnt = 1;
						if (map[j][i] == 0) {
							while (true) {
								if (i + cnt >= N)
									break;

								if (map[j][i + cnt] != 0) {
									map[j][i] = map[j][i + cnt];
									map[j][i + cnt] = 0;
									break;
								}

								if (map[j][i + cnt] == 0) {
									cnt++;
								}
							}
						} else
							continue;
					}
				}
				break;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				if(i != N-1) sb.append("\n");
			}
			System.out.print(sb);
		}
	}
}
