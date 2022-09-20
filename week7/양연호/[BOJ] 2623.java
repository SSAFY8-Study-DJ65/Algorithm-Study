package m09w2;
/*
 * BOJ : 2623 G3 음악프로그램
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02623 {

	static int N, M;
	static int[] indegree;
	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		indegree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt-1; j++) {
				int y = Integer.parseInt(st.nextToken());
				adj[x].add(y);
				indegree[y]++;
				x = y;
			}
		}
		
		res = new ArrayList<>();
		
		topology();
		
		if (res.size() != N) System.out.println(0);
		else {
			for (int r : res) {
				sb.append(r).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void topology() {
		Queue<Integer> Q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) Q.add(i);
		}
		
		while(!Q.isEmpty()) {
			int x = Q.poll();
			res.add(x);
			for (int y : adj[x]) {
				indegree[y]--;
				if (indegree[y] == 0) Q.add(y);
			}
		}
	}

}
