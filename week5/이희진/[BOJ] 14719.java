import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] map = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		//현재 위치 기준으로 양옆에 큰 벽 찾기
		for(int i = 1; i < W-1; i++) {
			int left = 0;
			int right = 0;
			
			//욍
			for(int j = i-1; j >= 0; j--) {
				left = Math.max(left, map[j]);
			}
			
			//옹
			for(int j = i+1; j < W; j++) {
				right = Math.max(right, map[j]);
			}
			
			if(left < map[i] || right < map[i]) continue;
			
			int min = Math.min(left, right);
			ans = ans + min - map[i];

		}
		System.out.println(ans);
	}
}
