import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int i=0; i<N; i++) {
				String line = "";
				for(int j=0; j<N; j++) {
					line += map[j][i];
				}
				String bef = line.replace("0", "");
				String aft = bef.replace("12", "");
				ans += (bef.length() - aft.length())/2;
			}
			
			System.out.println("#" + t + " " + ans);
			
			}
	}

}
