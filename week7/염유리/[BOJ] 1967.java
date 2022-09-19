import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * G4 트리의 지름
 */
public class Main {

	static int n, ans=0;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	static class Node{
		int v;
		int w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 n = Integer.parseInt(br.readLine());
		 
		 list = new ArrayList[n+1];
		 for(int i=1; i<n+1; i++) {
			 list[i] = new ArrayList<Node>();
		 }
		 
		 for(int i=0; i<n-1; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int u = Integer.parseInt(st.nextToken());
			 int v = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			 
			 list[u].add(new Node(v, w));
			 list[v].add(new Node(u, w));
		 }
		 
//		 for(int i=1; i<n+1; i++) {
//			 System.out.println(list[i].toString());
//		 }
		 
		 for(int i=1; i<n+1; i++) {
			 visited = new boolean[n+1];
			 dfs(i, 0);
		 }
		 
		 System.out.println(ans);
	}
	
	public static void dfs(int v, int sum) {
		ans = Math.max(ans, sum);
		
		for(Node next : list[v]) {
			if(visited[next.v]) continue;
			visited[v] = true;
			dfs(next.v, sum + next.w);
		}
	}

}
