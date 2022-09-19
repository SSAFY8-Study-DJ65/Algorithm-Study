import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BOJ 2623 G3 음악프로그램
 * 
 */
public class Main {

	static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static int V, E;
	static int[] inDegree;
	static Node[] adjList;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V+1]; // 각 정점별 인접리스트
		inDegree = new int[V+1]; // 정점별 진입차수
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			int cnt = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt-1; j++) {
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
				from = to;
			}
		}
		
		ArrayList<Integer> list = topologySort();
		if(list.size() == V) { // 위상정렬 완성
			for(int l : list) {
				System.out.println(l + " ");
			}
			
		}else {
			System.out.println("0");
		}
	}
	
	private static ArrayList<Integer> topologySort(){
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		
		// BFS
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(--inDegree[temp.vertex] == 0) queue.offer(temp.vertex);
			}
		}
		
		return list;
	}

}
