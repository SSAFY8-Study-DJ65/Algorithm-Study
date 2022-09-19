package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		in = new int[n + 1];
		adj = new ArrayList[n + 1];
		res = new ArrayList<>();

		for (int i = 0; i <= n; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			for (int j = 0; j < cnt - 1; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				in[to]++; // to 정점으로 들어오는 간선 수 + 1
				from = to;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (in[i] == 0) // 들어오는 간선이 없는 정점
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int from = q.poll();
			res.add(from);
			for (int to : adj[from]) {
				in[to]--;
				if (in[to] == 0)
					q.offer(to);
			}
		}

		if (res.size() == n)
			for (int temp : res)
				System.out.println(temp);
		else {
			System.out.println(0);
		}
	}

	static int n, m;
	static int[] in;
	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> res;
}
