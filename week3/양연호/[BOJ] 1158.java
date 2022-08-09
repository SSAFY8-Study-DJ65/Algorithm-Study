package m08w2;
/*
 * BOJ : 1158 S4 요세푸스 문제
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01158 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			que.add(i+1);
		}
		
		System.out.print("<");
		while (que.size() > 1) {
			for (int i = 0; i < K-1; i++) {
				que.offer(que.poll());
			}
			System.out.print(que.poll() + ", ");
		}
		System.out.println(que.poll() + ">");
		
	}

}
