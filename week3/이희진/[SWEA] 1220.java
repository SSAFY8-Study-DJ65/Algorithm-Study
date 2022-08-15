import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d31220 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int map[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			
			for(int i = 0; i < N; i++) {
				boolean check = false;
				for(int j = 0; j < N; j++) {
					if(map[j][i] == 1) {
						check = true;						
					} else if(map[j][i] == 2 && check) {
						check = false;
						cnt++;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
