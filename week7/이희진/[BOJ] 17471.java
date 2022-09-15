import java.io.*;
import java.util.*;

public class Main {

	static int N, min;
	static int[] population;
	static int[] arr = { 1, 2, 3, 4, 5, 6 };
	static boolean[] sv;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		population = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		adj = new ArrayList[N +1];
		for (int i = 0; i <= N; i++) {
//			System.out.println("??");
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		min = Integer.MAX_VALUE;

//		arr = new int[N+1];
		sv = new boolean[N + 1];

//		for(int i = 0; i <= N; i++) {
//			arr[i] = i;
//		}

//		System.out.println(Arrays.toString(v));
		subs(1);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);

	}

	public static void subs(int depth) {
//		System.out.println(N+"/"+depth);
		if (depth == N+1) {
			if (bfs()) {
				int cnta = 0;
				int cntb = 0;
				for (int i = 1; i <= N; i++) {
//				if(sv[i]) System.out.print(arr[i] +" ");
					if (sv[i])
						cnta = cnta + population[i];
					else
						cntb = cntb + population[i];
				}

				min = Math.min(min, Math.abs(cnta - cntb));
			}
//			System.out.println();
			return;
		}

		sv[depth] = true;
		subs(depth + 1);
		sv[depth] = false;
		subs(depth + 1);
	}

	public static boolean bfs() {
		boolean[] v = new boolean[N + 1];

		int checka = 0;
//		첫번째 지역
		for (int i = 1; i <= N; i++) {
			if (sv[i]) {
				checka = i;
			}
		}

		int checkb = 0;
//		두번째 지역
		for (int i = 1; i <= N; i++) {
			if (!sv[i]) {
				checkb = i;
			}
		}

		if (checka == 0 || checkb == 0)
			return false;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(checka);
		v[checka] = true;

		while (!q.isEmpty()) {
			int i = q.poll();
//			System.out.println(i);
			for (int j = 0; j < adj[i].size(); j++) {
				if (!v[adj[i].get(j)] && sv[adj[i].get(j)]) {
					v[adj[i].get(j)] = true;
					q.offer(adj[i].get(j));
				}
			}
		}

		q.offer(checkb);
		v[checkb] = true;

		while (!q.isEmpty()) {
			int i = q.poll();
			for (int j = 0; j < adj[i].size(); j++) {
				if (!v[adj[i].get(j)] && !sv[adj[i].get(j)]) {
					v[adj[i].get(j)] = true;
					q.offer(adj[i].get(j));
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!v[i])
				return false;
		}
		return true;
	}
}
