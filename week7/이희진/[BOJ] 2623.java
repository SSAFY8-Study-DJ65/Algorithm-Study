import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int v;
		Node next;

		public Node(int v, Node next) {
			this.v = v;
			this.next = next;
		}
	}

	static int N, M;
	static int[] degree;
	static ArrayList<Integer>[] adj;
//	static Node[] adj;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
//		adj = new Node[N + 1];
		degree = new int[N + 1];

		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < temp-1; i++) {
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
//				adj[from] = new Node(to, adj[from]);
				degree[to]++;
				from = to;
			}
		}
		
		ArrayList<Integer> list = mola();

		StringBuilder sb = new StringBuilder();

		if (list.size() == N) {
			for (Integer i : list) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		};
		if(sb.length() == 0) System.out.println(0); 
		else System.out.println(sb);
	}

	public static ArrayList<Integer> mola() {
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			list.add(cur);

			for (int i = 0; i < adj[cur].size(); i++) {
				int next = adj[cur].get(i);
				if (--degree[next] == 0)
					q.offer(next);
			}
		}
		return list;
	}
}
