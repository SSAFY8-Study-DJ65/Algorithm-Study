import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21608 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		totalStu = n * n;

		stuPos = new Pos[totalStu + 1]; // 각 학생의 위치
		chkStu = new boolean[totalStu + 1]; // 각 학생의 자리 배정 여부

		map = new int[n][n]; // 자리 배정
		cntNear = new int[n][n]; // 각 위치별 비어있는 인접 자리 개수

		makeMap();

		likeArr = new ArrayList[totalStu + 1];
		for (int i = 1; i < totalStu + 1; i++) {
			likeArr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < totalStu; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			int[][] chkNear = new int[n][n];
			boolean flag = false;
			for (int j = 0; j < 4; j++) {
				int stuNum = Integer.parseInt(st.nextToken());
				likeArr[idx].add(stuNum);
				if (chkStu[stuNum]) {
					Pos p = stuPos[stuNum];
					for (int[] d : dir) {
						int nearX = p.x + d[0];
						int nearY = p.y + d[1];
						if (check(nearX, nearY) && map[nearX][nearY] == 0) {
							chkNear[nearX][nearY]++;
							flag = true;
						}
					}
				}
			}

			int max = -1;
			int x = 0;
			int y = 0;
			if (flag) { // 좋아하는 학생이 자리에 있고 그 주변 자리가 비어있는 경우 -> 조건에 맞는 적합한 자리 찾기
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (chkNear[r][c] > max) {
							max = chkNear[r][c];
							x = r;
							y = c;
						} else if (chkNear[r][c] == max) {
							if (cntNear[r][c] > cntNear[x][y]) {
								x = r;
								y = c;
							} else if (cntNear[r][c] == cntNear[x][y] && (r < x || (r == x && c < y))) {
								x = r;
								y = c;
							}
						}
					}
				}
			} else { // 좋아하는 학생이 아직 자리에 없는 경우
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (map[r][c] == 0 && cntNear[r][c] > max) {
							max = cntNear[r][c];
							x = r;
							y = c;
						}
					}
				}
			}
//			print(chkNear);
//			print(cntNear);

			stuPos[idx] = new Pos(x, y);
			chkStu[idx] = true;
			map[x][y] = idx;
			for (int[] d : dir) {
				int nearX = x + d[0];
				int nearY = y + d[1];
				if (check(nearX, nearY) && cntNear[nearX][nearY] > 0)
					cntNear[nearX][nearY]--;
			}
//			print(map);
//			System.out.println("------");
		}

		res = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				ArrayList<Integer> like = likeArr[map[r][c]];
				int cnt = 0;
				for (int[] d : dir) {
					int nearX = r + d[0];
					int nearY = c + d[1];
					if (check(nearX, nearY)) {
						for (int num : like) {
							if (map[nearX][nearY] == num)
								cnt++;
						}
					}
				}
				if (cnt > 0)
					res += Math.pow(10, cnt - 1);
			}
		}
		System.out.println(res);
	}

	static int n, totalStu, res;
	static int[][] cntNear, map, dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[] chkStu;
	static Pos[] stuPos;
	static ArrayList<Integer>[] likeArr;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void makeMap() {
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				cntNear[i][j] = 4;
			}
		}
		for (int i = 1; i < n - 1; i++) {
			cntNear[0][i] = 3;
			cntNear[n - 1][i] = 3;
			cntNear[i][0] = 3;
			cntNear[i][n - 1] = 3;
		}
		cntNear[0][0] = 2;
		cntNear[0][n - 1] = 2;
		cntNear[n - 1][0] = 2;
		cntNear[n - 1][n - 1] = 2;
	}

	private static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
