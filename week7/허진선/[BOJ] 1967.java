package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[from].add(new Edge(to, w));
			adj[to].add(new Edge(from, w));

		}
		start = 0;
		max = 0;
		v = new boolean[n + 1];
		dfs(1, 0);

		max = 0;
		v = new boolean[n + 1];
		dfs(start, 0);

		System.out.println(max);
	}

	static int n, max, start;
	static ArrayList<Edge>[] adj;
	static boolean[] v;

	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static public void dfs(int vertex, int w) {
		if (v[vertex]) {
			return;
		} else {
			v[vertex] = true;
		}
		
		if (max < w) {
			max = w;
			start = vertex;
		}

		for (Edge a : adj[vertex]) {
			dfs(a.v, w + a.w);
		}
	}
}
