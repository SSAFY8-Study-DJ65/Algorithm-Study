package m08w2;
/*
 * SWEA : 4050 D4 재관이의 대량 할인
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_04050 {

	static int T, N, sum;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bf.readLine());
			num = new int[N];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(num);
			sum = 0;
			for (int i = N-1; i >= 0; i-=3) {
				sum += num[i];
				if (i-1 >= 0) {
					sum += num[i-1];
				}
			}
			
			System.out.println("#" + tc + " " + sum);
			
		}
	}

}
