import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 1647 G4 도시 분할 계획
 */
public class Main {

	static int V, E;
	static int[][] edges;
	static int[] parents;
	static int[] rank;
	static int[][] sel;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		edges = new int[E][3];
		
		for(int i=0; i<E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		Arrays.sort(edges, new Comparator<int[]>( ) {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}			
		});
		
		parents = new int[V+1];
		rank = new int[V+1];
		sel = new int[V-1][3];
		
		for(int i=0; i<parents.length; i++) {
			parents[i] = i;
		}
		
		int cnt = 0;
		for(int i=0; i<E; i++) {
			int pi = findSet(edges[i][0]);
			int pj = findSet(edges[i][1]);
			
			if(pi == pj) continue;
			
			union(pi, pj);
			sel[cnt] = edges[i];
			cnt++;
			if(cnt == V-1) break;
		}
		
		int max = 0;
		int ans = 0;
		for(int i=0; i<V-1; i++) {
			ans += sel[i][2];
			max = Math.max(max, sel[i][2]);
		}
		
		System.out.println(ans - max);
	}
	
	private static void union(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);
		
		if(rank[pi] > rank[pj]) {
			parents[pj] = pi;
		}else {
			parents[pi] = pj;
			if(rank[pi] == rank[pj]) {
				rank[pj]++;
			}
		}
	}
	
	private static int findSet(int i) {
		if(parents[i] == i)
			return i;
		
		return parents[i] = findSet(parents[i]);
	}
	
}
