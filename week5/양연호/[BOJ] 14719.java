package m08w4;
/*
 * BOJ : 14719 G5 빗물
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int res = 0;
		
		int[] block = new int[W];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W-1; i++) {
			int now = block[i];
			int left = now;
			int right = now;
			
			for (int j = i-1; j >= 0; j--) {
				if (block[j] > now) {
					left = Math.max(left, block[j]);
				}
			}
			
			for (int j = i+1; j < W; j++) {
				if (block[j] > now) {
					right = Math.max(right, block[j]);
				}
			}
			
			if (Math.min(left, right) > now) {
				res += Math.min(left, right) - block[i];
			}
		}
		
		System.out.println(res);
	}

}
