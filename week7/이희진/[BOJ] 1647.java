import java.io.*;
import java.util.*;

public class Main {

	static class Vertex implements Comparable<Vertex> {
		int e, w;

		Vertex(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}

	static int N, M;
	static ArrayList<Vertex>[] adj;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

//		인접리스트
		adj = new ArrayList[N];
		dist = new int[N];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());

			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));
		}

//		최소값을 저장하고 구하기 위해 PQ를 생성한다
		PriorityQueue<Vertex> Q = new PriorityQueue();

//		각 정점의 방문여부배열
		boolean[] v = new boolean[N];
		
//		0번 정점에 거리값을 0으로 초기화
		dist[0] = 0;
		
//		0번 을 기준정점으로 선택
//		시작정점을 Q 에 넣는다
//		저장할때 Comparable 구현에 의해 heap sort 를 이용하여 정렬이 이루어 진다
		Q.add(new Vertex(0, 0));
		
//		최대 가중치 저장 변수
		int max = 0;
		
//		가중치 저장 변수
		int sum = 0;
		
		while (!Q.isEmpty()) {
//			거리가 가장 작은 노드가 리턴됩니다
			Vertex p = Q.poll();
//			방문되지 않은 노드라면
			if (!v[p.e]) {
				v[p.e] = true;
				max = Math.max(max, p.w);
				sum += p.w;
//				기준 정점과 연결된 노드들을 Q 에 넣는다
				for (Vertex next : adj[p.e]) {
					if (!v[next.e] && dist[next.e] > next.w) {
						dist[next.e] = next.w;
						Q.add(next);
					}
				}
			}
		}
		System.out.println(sum-max);
	}
}
