package m09w2;
/*
 * BOJ : 1967 G4 트리의 지름
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01967 {

	static int N, res;
	static ArrayList<Vertex>[] adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));
		}
		
		res = 0;
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i, 0);
		}
		
		System.out.println(res);
	}

	private static void dfs(int idx, int w) {
		for (Vertex next : adj[idx]) {
			if (!visited[next.e]) {
				visited[next.e] = true;
				dfs(next.e, w+next.w);
			}
		}
		
		res = Math.max(res, w);
	}

	static class Vertex {
		int e;
		int w;
		
		Vertex (int e, int w) {
			this.e = e;
			this.w = w;
		}
	}
}
