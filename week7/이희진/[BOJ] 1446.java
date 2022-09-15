import java.io.*;
import java.util.*;

public class Main {
	
	static class Point {
		int f, t, d;
		
		public Point(int f, int t, int d) {
			this.f = f;
			this.t = t;
			this.d = d;
		}
	}

	static ArrayList<Point> adj;
	static int N, D, min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		adj = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(b > D) continue;
			if(b-a <= c) continue;
			
			adj.add(new Point(a, b, c));
		}

		min = Integer.MAX_VALUE;
		
		dijk(0, 0);
		
		System.out.println(min);

	}
	
	static void dijk(int v, int dist) {
		if(dist >= min) return;
		
		if(v == D) {
			min = Math.min(dist, min);
			return;
		}
		
		for(int i = 0; i < adj.size(); i++) {
			Point p = adj.get(i);
			if(p.f == v) {
				dijk(p.t, dist+p.d);
			}
		}
		
		dijk(v+1, dist+1);
	}
}
