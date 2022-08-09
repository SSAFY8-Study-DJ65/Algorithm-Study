package m08w2;
/*
 * BOJ : 2563 B1 색종이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		int[][] arr = new int[100][100];
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int res = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					res++;
				}
			}
		}
		System.out.println(res);
	}

}
