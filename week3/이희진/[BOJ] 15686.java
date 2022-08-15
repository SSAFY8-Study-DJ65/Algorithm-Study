import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class g515686 {
	
	static int house;
	static int chicken;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Integer> chickeni;
	static ArrayList<Integer> chickenj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int map[][] = new int[N + 1][N + 1];
		house = 0;
		chicken = 0;
		chickeni = new ArrayList<>();
		chickenj = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					house++;
				else if (map[i][j] == 2) {
					chicken++;
					chickeni.add(i);
					chickenj.add(j);
				}
			}
		}
		int arr[] = new int[chicken];
		int sel[] = new int[M];
		for(int i = 0; i < chicken; i++) {
			arr[i] = i;
		}
		
		re(arr, sel, 0, 0, M, N, map);
		System.out.println(min);
	}
	
	public static void re(int[] arr, int[] sel, int idx, int k, int M, int N, int[][] map) {
		if(k == sel.length) {
			int sum = 0;
			int temp = 0;
			int [] dis = new int[house];
			
			for (int i = 0; i < house; i++)
				dis[i] = Integer.MAX_VALUE;
			
			int housetemp = 0;
			for (int tc = 0; tc < sel.length; tc++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (map[i][j] == 1) {
							temp = Math.abs(i - chickeni.get(sel[tc])) + Math.abs(j - chickenj.get(sel[tc]));
							dis[housetemp] = Math.min(dis[housetemp], temp);
							housetemp++;
						}
					}
				}
				housetemp = 0;
			}
			for(int i = 0; i < dis.length; i++) {
				sum+=dis[i];
			}
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			re(arr, sel, i+1, k+1, M, N, map);
		}
	}
}
