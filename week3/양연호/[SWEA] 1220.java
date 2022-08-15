package m08w2;
/*
 * SWEA : 1220 D3 Magnetic
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_01220 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int res = 0;
			for (int i = 0; i < N; i++) {
				boolean check = false;
				for (int j = 0; j < N; j++) {
					if (arr[j][i] == 1) {
						check = true;
					} else if (arr[j][i] == 2) {
						if (check) {
							check = false;
							res++;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}

}
