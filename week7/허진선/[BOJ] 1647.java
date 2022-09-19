package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		p = new int[n + 1];
		pq = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, c));
		}

		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
		for (int i = 1; i < n - 1;) {
			Edge cur = pq.poll();
			if (find(cur.from) != find(cur.to)) {
				union(cur.from, cur.to);
				ans += cur.w;
				i++;
			}
		}
		System.out.println(ans);
	}

	static int n, m, ans;
	static int[] p;
	static PriorityQueue<Edge> pq;

	static class Edge implements Comparable<Edge> {

		int from, to, w;

		public Edge(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static int find(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;

		if (x > y)
			p[y] = x;
		else
			p[x] = y;
	}
}
