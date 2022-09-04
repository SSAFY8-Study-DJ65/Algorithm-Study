package m08w3;
/*
 * SWEA : 5658 모의 보물상자 비밀번호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_05658 {

	static int T, N, K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			Queue<Character> q = new LinkedList<>();
			String s = bf.readLine();
			for (int i = 0; i < N; i++) {
				q.add(s.charAt(i));
			}
			
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < N/4; i++) {
				q.add(q.poll());
				for (int j = 0; j < 4; j++) {
					String str = "";
					for (int k = 0; k < N/4; k++) {
						char tmp = q.poll();
						str += tmp;
						q.add(tmp);
					}
					set.add(Integer.parseInt(str, 16));
				}
			}
			
			ArrayList<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			System.out.println("#" + tc + " " + list.get(list.size()-K));
		}
	}

}
