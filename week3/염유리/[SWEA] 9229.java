import java.util.Scanner;

public class Solution {

	static int N, M, max;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			max = 0;
			visited = new boolean[N];
			dfs(0, 0);
			
			if(max == 0) max = -1;
			
			System.out.println("#" + t + " "+ max);
		}

		
	}
	
	public static void dfs(int k, int sum) {
		if(k == 2) {
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(k+1, sum+arr[i]);
			visited[i] = false;
		}
		
	}

}
