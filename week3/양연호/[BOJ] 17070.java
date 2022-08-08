package m08w2;
/*
 * BOJ : 17070 G5 파이프 옮기기 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {

	static int N, res;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		pipe(0, 0, 0, 1);
		System.out.println(res);
	}

	private static void pipe(int x1, int y1, int x2, int y2) {
		if (x2 == N-1 && y2 == N-1) {
			res++;
			return;
		}
		
		if (x1 == x2) {	// 가로
			if (y2+1 < N && arr[x2][y2+1] == 0) {
				pipe(x2, y2, x2, y2+1);
			}
			if (x2+1 < N && y2+1 < N && arr[x2+1][y2+1] == 0 && arr[x2+1][y2] == 0 && arr[x2][y2+1] == 0) {
				pipe(x2, y2, x2+1, y2+1);
			}
		} else if(x1+1 == x2 && y1+1 == y2) {	// 대각선
			if (y2+1 < N && arr[x2][y2+1] == 0) {
				pipe(x2, y2, x2, y2+1);
			}
			if (x2+1 < N && y2+1 < N && arr[x2+1][y2+1] == 0 && arr[x2+1][y2] == 0 && arr[x2][y2+1] == 0) {
				pipe(x2, y2, x2+1, y2+1);
			}
			if (x2+1 < N && arr[x2+1][y2] == 0) {
				pipe(x2, y2, x2+1, y2);
			}
		} else if (y1 == y2) {	//세로
			if (x2+1 < N && arr[x2+1][y2] == 0) {
				pipe(x2, y2, x2+1, y2);
			}
			if (x2+1 < N && y2+1 < N && arr[x2+1][y2+1] == 0 && arr[x2+1][y2] == 0 && arr[x2][y2+1] == 0) {
				pipe(x2, y2, x2+1, y2+1);
			}
		}
	}

}
