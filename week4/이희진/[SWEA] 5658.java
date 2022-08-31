import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class sw5658 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder ans = new StringBuilder();
			
			//숫자의 개수, 크기 순서
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int a = N/4;
			
			StringBuilder str = new StringBuilder();

			str.append(br.readLine());
			
			ArrayList<String> hex = new ArrayList<>();
			
			for(int i = 0; i < a; i++) {
				int start = 0;
				for(int j = 0; j < 4; j++) {
					String temp = str.substring(start, start+a);
					if(!hex.contains(temp)) {
						hex.add(temp);
					}
					start += a;
				}
				str.insert(0, str.charAt(start-1));
				str.deleteCharAt(N);
			}
			
			Collections.sort(hex, Collections.reverseOrder());
			ans.append("#").append(tc).append(" ").append(Integer.parseInt(hex.get(K-1), 16));
			System.out.println(ans);
		}
	}
}
