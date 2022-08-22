package m08w3;
/*
 * SWEA : 6109 D4 추억의 2048게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_06109 {

	static int T, N, idx;
	static String S;
	static int[][] board;
	static int[][] res;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = new int[N][N];
			if (S.equals("up")) {
				for (int i = 0; i < N; i++) {
					stack = new Stack<>();
					idx = 0;
					for (int j = 0; j < N; j++) {
						if (board[j][i] == 0)
							continue;
						
						if (stack.empty()) {
							stack.add(board[j][i]);
							continue;
						}
						
						if (stack.peek() == board[j][i]) {
							res[idx][i] = stack.pop() + board[j][i];
							board[j][i] = 0;
							idx++;
						} else {
							res[idx][i] = stack.pop();
							stack.add(board[j][i]);
							idx++;
						}
					}
					if (!stack.empty()) {
						res[idx][i] = stack.pop();
					}
				}
			} else if (S.equals("down")) {
				for (int i = 0; i < N; i++) {
					stack = new Stack<>();
					idx = N-1;
					for (int j = N-1; j >= 0; j--) {
						if (board[j][i] == 0)
							continue;
						
						if (stack.empty()) {
							stack.add(board[j][i]);
							continue;
						}
						
						if (stack.peek() == board[j][i]) {
							res[idx][i] = stack.pop() + board[j][i];
							board[j][i] = 0;
							idx--;
						} else {
							res[idx][i] = stack.pop();
							stack.add(board[j][i]);
							idx--;
						}
					}
					if (!stack.empty()) {
						res[idx][i] = stack.pop();
					}
				}
			} else if (S.equals("left")) {
				for (int i = 0; i < N; i++) {
					stack = new Stack<>();
					idx = 0;
					for (int j = 0; j < N; j++) {
						if (board[i][j] == 0)
							continue;
						
						if (stack.empty()) {
							stack.add(board[i][j]);
							continue;
						}
						
						if (stack.peek() == board[i][j]) {
							res[i][idx] = stack.pop() + board[i][j];
							board[i][j] = 0;
							idx++;
						} else {
							res[i][idx] = stack.pop();
							stack.add(board[i][j]);
							idx++;
						}
					}
					if (!stack.empty()) {
						res[i][idx] = stack.pop();
					}
				}
			} else if (S.equals("right")) {
				for (int i = 0; i < N; i++) {
					stack = new Stack<>();
					idx = N-1;
					for (int j = N-1; j >= 0; j--) {
						if (board[i][j] == 0)
							continue;
						
						if (stack.empty()) {
							stack.add(board[i][j]);
							continue;
						}
						
						if (stack.peek() == board[i][j]) {
							res[i][idx] = stack.pop() + board[i][j];
							board[i][j] = 0;
							idx--;
						} else {
							res[i][idx] = stack.pop();
							stack.add(board[i][j]);
							idx--;
						}
					}
					if (!stack.empty()) {
						res[i][idx] = stack.pop();
					}
				}
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
