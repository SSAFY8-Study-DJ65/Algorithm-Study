package m09w2;
/*
 * BOJ : 1446 S1 지름길
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01446 {

	static int N, D;
	static List<Shortcut>[] shortcut;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		shortcut = new List[10001];
		distance = new int[10001];
		for (int i = 0; i < 10001; i++) {
			distance[i] = i;
			shortcut[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			shortcut[a].add(new Shortcut(b, c));
		}
		
		recur(0);
		System.out.println(distance[D]);
	}

	private static void recur(int start) {
		if (start > D) return;
		
		if (distance[start+1] > distance[start] + 1) {
			distance[start+1] = distance[start] + 1;
		}
		
		for (int i = 0; i < shortcut[start].size(); i++) {
			if (distance[shortcut[start].get(i).e] > distance[start] + shortcut[start].get(i).w) {
				distance[shortcut[start].get(i).e] = distance[start] + shortcut[start].get(i).w;
			}
		}
		
		recur(start+1);
	}

	static class Shortcut implements Comparable<Shortcut>{
		int e;
		int w;
		
		Shortcut(int e, int w) {
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Shortcut o) {
			return Integer.compare(this.w, o.w);
		}
	}

}
