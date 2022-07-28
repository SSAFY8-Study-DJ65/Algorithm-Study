import java.util.Scanner;
/*
 * SWEA 6730 장애물 경주 난이도
 */
public class SWEA_06730 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] block = new int[N];
			for (int i = 0; i < N; i++) {
				block[i] = sc.nextInt();
			}
			
			int up = 0, down = 0;
			
			for (int i = 0; i < N-1; i++) {
				if (block[i] < block[i+1]) {
					up = Math.max(up, block[i+1]-block[i]);
				}
				
				if (block[i] > block[i+1]) {
					down = Math.max(down, block[i] - block[i+1]);
				}
			}
			System.out.println("#" + tc + " " + up + " " + down);
		}
		sc.close();
	}

}
