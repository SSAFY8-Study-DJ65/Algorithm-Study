package m09w2;
/*
 * BOJ : 1647 G4 도시 분할 계획
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01647 {

	static int N, M, cnt, max_w, res;
	static boolean[] visited;
	static ArrayList<Vertex>[] adj;
	static PriorityQueue<Vertex> PQ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));
		}
		
		visited = new boolean[N+1];
		
		PQ = new PriorityQueue<>();
		PQ.add(new Vertex(1, 0));
		max_w = 0;
		cnt = 0;
		res = 0;
		
		while (!PQ.isEmpty()) {
			Vertex now = PQ.poll();
			
			if (visited[now.e]) continue;
			
			visited[now.e] = true; 
			res += now.w;
			max_w = Math.max(max_w, now.w);
			
			for (Vertex next : adj[now.e]) {
				if (!visited[next.e]) {
					PQ.add(new Vertex(next.e, next.w));
				}
			}
		}
		
		System.out.println(res - max_w);
	}
	
	static class Vertex implements Comparable<Vertex>{
		int e;
		int w;
		
		Vertex(int e, int w) {
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.w, o.w);
		}
	}

}
