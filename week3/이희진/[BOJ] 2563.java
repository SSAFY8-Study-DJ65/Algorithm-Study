import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12563 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int arr[][] = new int[100][100];
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0 ; j < 100; j++) {
				arr[i][j] = 0;
			}
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					if(k < 100 && j < 100 && arr[j][k] == 0) {
						arr[j][k] = 1;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
