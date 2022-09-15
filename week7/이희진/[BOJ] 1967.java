import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int to, w;

		Node(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public String toString() {
			return this.to + "/" + this.w;
		}
	}

	static int N, max;
	static List<Node>[] g;
	static boolean[] v;
	static Node maxnode;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		g = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			g[i] = new ArrayList<>();
		}

		v = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			g[from].add(new Node(to, w));
			g[to].add(new Node(from, w));
		}

		max = 0;

//		가장 멀리 있는 노드부터 찾고 다시 젤 멀리 있는 노드 찾기
		if (N > 1) {
			dfs(g[1].get(0), 0);
			
			Arrays.fill(v, false);

			Node n = maxnode;
			dfs(n, 0);
		}
		System.out.println(max);
	}

	static void dfs(Node temp, int sum) {
		if (sum > max) {
			max = sum;
			maxnode = temp;
		}

		v[temp.to] = true;

		for (int d = 0; d < g[temp.to].size(); d++) {
			int di = g[temp.to].get(d).to;
			if (!v[di]) {
				dfs(g[temp.to].get(d), sum + g[temp.to].get(d).w);
			}
		}
	}
}
