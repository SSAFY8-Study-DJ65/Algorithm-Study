import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int vertex,weight;
		Node(int vertex,int weight){
			this.vertex=vertex;
			this.weight=weight;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "vertex: "+this.vertex+" weight: "+this.weight;
		}
		
	}
	
	static int v;
	static ArrayList<Node>[] arr;
	static int res;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v=Integer.parseInt(br.readLine());
		
		arr= new ArrayList[v+1];
		
		for(int i=1;i<=v;i++) {
			arr[i]=new ArrayList<Node>();
		}
		
		for(int i=0;i<v-1;i++) {
			StringTokenizer str= new StringTokenizer(br.readLine());
			int from=Integer.parseInt(str.nextToken());
			int to=Integer.parseInt(str.nextToken());
			int weight=Integer.parseInt(str.nextToken());
			
			arr[from].add(new Node(to,weight));
			arr[to].add(new Node(from,weight));
		}
		
		//System.out.println(Arrays.toString(arr));
		
		for(int i=1;i<=v;i++) {
			visited=new boolean[v+1];
			dfs(i,0);
		}
		
		System.out.println(res);
	}

	private static void dfs(int vertex, int sum) {
		//System.out.println(sum);
		res=Math.max(res,sum);
		
		for(Node tmp : arr[vertex]) {
			if(!visited[tmp.vertex]) {
				visited[vertex]=true;
				dfs(tmp.vertex,sum+tmp.weight);
			}
		}
	}
}
