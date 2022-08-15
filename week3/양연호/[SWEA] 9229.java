package m08w2;
/*
 * SWEA : 9229 D3 한빈이와 Spot Mart
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_09229 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] weight = new int[N];
			
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			int res = -1;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					int tmp = weight[i] + weight[j];
					if (tmp <= M) {
						if (tmp > res) {
							res = tmp;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}

}
