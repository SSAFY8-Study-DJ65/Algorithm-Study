package G5;

import java.io.*;
import java.util.*;

public class G521608 {

	static class Student {
		int num;
		int[] freinds;

		public Student(int num, int[] friends) {
			this.num = num;
			this.freinds = friends;
		}
	}

	static int N;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int[][] arr;
	static boolean[][] v;
	static ArrayList<Student> s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Student> h_stu = new HashMap<>();

		N = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		v = new boolean[N][N];
		s = new ArrayList<>();

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp[] = new int[4];
			int a = Integer.parseInt(st.nextToken());
			temp[0] = Integer.parseInt(st.nextToken());
			temp[1] = Integer.parseInt(st.nextToken());
			temp[2] = Integer.parseInt(st.nextToken());
			temp[3] = Integer.parseInt(st.nextToken());

			s.add(new Student(a, temp));
		}

//		System.out.println(s);

		int[][] empty = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				empty[i][j] = 4;
				if (i == 0 || i == N - 1)
					empty[i][j]--;
				if (j == 0 || j == N - 1)
					empty[i][j]--;
			}
		}
		
		int[][] map = new int[N][N];
		map[1][1] = s.get(0).num;
		empty[0][1]--;
		empty[2][1]--;
		empty[1][0]--;
		empty[1][2]--;

		for (int k = 1; k < N * N; k++) {
			Student stmp = s.get(k);
			int[][] like = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0)
						continue;

					for (int d = 0; d < 4; d++) {
						int nx = i + di[d];
						int ny = j + dj[d];
						if (0 <= nx && nx < N && 0 <= ny && ny < N) {
							for (int sn : stmp.freinds) {
								if (sn == map[nx][ny]) {
									like[i][j]++;
								}
							}
						}
					}
				}
			}

			int max_empty = -1;
			int max_like = -1;
			int row = -1;
			int col = -1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0)
						continue;
					if (like[i][j] > max_like) {
						max_like = like[i][j];
						max_empty = empty[i][j];
						row = i;
						col = j;
					} else if (like[i][j] == max_like && empty[i][j] > max_empty) {
						max_empty = empty[i][j];
						row = i;
						col = j;
					}
				}
			}

			map[row][col] = stmp.num;
			h_stu.put(stmp.num, stmp);
			for (int d = 0; d < 4; d++) {
				int nx = row + di[d];
				int ny = col + dj[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					empty[nx][ny]--;
				}
			}

		}

		int like_score = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int k = 0; k < s.size(); k++) {
					if (s.get(k).num == map[i][j]) {
						for (int d = 0; d < 4; d++) {
							int nx = i + di[d];
							int ny = j + dj[d];
							if (0 <= nx && nx < N && 0 <= ny && ny < N) {
								for (int s_n : s.get(k).freinds) {
									if (map[nx][ny] == s_n) {
										cnt++;
									}
								}
							}
						}
					}
				}

				if (cnt == 1) {
					like_score++;
				} else if (cnt == 2) {
					like_score += 10;
				} else if (cnt == 3) {
					like_score += 100;
				} else if (cnt == 4) {
					like_score += 1000;
				}
			}
		}
		
		System.out.println(like_score);
	}
}
