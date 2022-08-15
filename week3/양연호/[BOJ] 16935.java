package m08w2;
/*
 * BOJ : 16935 S1 배열 돌리기 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935 {

	static int[][] map;
	static int N, M, R, OP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] OP = new int[R];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < R; i++) {
			OP[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp;
		for (int i = 0; i < R; i++) {
			switch(OP[i]) {
			case 1:
				operation1();
				break;
			case 2:
				operation2();
				break;
			case 3:
				operation3();
				tmp = N;
				N = M;
				M = tmp;
				break;
			case 4:
				operation4();
				tmp = N;
				N = M;
				M = tmp;
				break;
			case 5:
				operation5();
				break;
			case 6:
				operation6();
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j =0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void operation1() {
		int[] tmp = new int[M];
		for (int i = 0; i < N/2; i++) {
			tmp = Arrays.copyOf(map[N-i-1], M);
			for (int j = 0; j < M; j++) {
				map[N-i-1][j] = map[i][j];
			}
			
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j];
			}
		}
	}

	private static void operation2() {
		int tmp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				tmp = map[i][j];
				map[i][j] = map[i][M-j-1];
				map[i][M-j-1] = tmp;
			}
		}
	}

	private static void operation3() {
		int[][] tmp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[j][N-i-1] = map[i][j];
			}
		}
		map = tmp;
	}

	private static void operation4() {
		int[][] tmp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[M-j-1][i] = map[i][j];
			}
		}
		map = tmp;
	}

	private static void operation5() {
		int[][] tmp = new int[N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				map[i-N/2][j] = map[i][j];
			}
		}
		
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				map[i][j-M/2] = map[i][j];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				map[i+N/2][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				map[i][j] = tmp[i][j-M/2];
			}
		}
	}

	private static void operation6() {
		int[][] tmp = new int[N/2][M/2];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < M/2; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			
			for (int i = 0; i < N/2; i++) {
				for (int j = M/2; j < M; j++) {
					map[i][j-M/2] = map[i][j];
				}
			}
			
			for (int i = N/2; i < N; i++) {
				for (int j = M/2; j < M; j++) {
					map[i-N/2][j] = map[i][j];
				}
			}
			
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					map[i][j+M/2] = map[i][j];
				}
			}
			
			for (int i = N/2; i < N; i++) {
				for (int j = 0; j < M/2; j++) {
					map[i][j] = tmp[i-N/2][j];
				}
			}
	}

}
