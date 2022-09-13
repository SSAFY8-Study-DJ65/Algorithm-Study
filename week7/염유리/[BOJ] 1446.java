import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N, D;
	static ArrayList<Node>[] adjList;
	static boolean[] visited;
	static int[] dist;
	
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		
		Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		D = sc.nextInt();

		adjList = new ArrayList[10001];
		
		for(int i=0; i<10001; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<N; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			adjList[u].add(new Node(v, w));
		}
		
		dist = new int[10001];
		
		for(int i=0; i<10001; i++){
			dist[i] = i;
		}
		
//		visited = new boolean[10001];
		
		dijkstra(0);
		
		System.out.println(dist[D]);
	
	}

	private static void dijkstra(int start) {
		
		dist[start] = 0;
		
		for(int i=0; i<=D; i++) {
			
			int now = i;
			
			// 전에꺼에서 1 더한걸로 설정해놓고
			if(now != 0 && dist[now] > dist[now-1] + 1) {
				dist[now] = dist[now-1] + 1;
			}
			
//			if(visited[now]) continue;
//			visited[now] = true;
			
			// 지름길이 있으면 비교
			for(Node next : adjList[now]) {
				if(dist[next.index] > dist[now] + next.distance) {
					dist[next.index] = dist[now] + next.distance;
//					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
		
		
	}

}
