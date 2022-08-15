import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class g417406 {

	static int[] dx = { 1, 0, -1, 0 }; //↓ → ↑ ← 
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static int[][] kkk;
	static int min;
	static int N;
	static int M;
	static int R;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		int tmp[][] = new int[N][M];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				tmp[i][j] = arr[i][j];
			}
		}
		min = 999999999;

		kkk = new int[R][3];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				kkk[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//조합 돌려		
		int johap[] = new int[R];
		int johapsel[] = new int[R];
		boolean[] v = new boolean[R];

		for(int i = 0; i < R; i++) {
			johap[i] = i;
		}

		re(johap, johapsel, v, 0, tmp);
		System.out.println(min);
		
	}
	
	public static void dola(int number, int[][] arr) {
		//돌려 돌려 돌림판
//		for (int tc = 0; tc < R; tc++) {
				
			//골라내
			int startx = kkk[number][0]-kkk[number][2]-1;
			int starty = kkk[number][1]-kkk[number][2]-1;
			
			int endx = kkk[number][0]+kkk[number][2]-1;
			int endy = kkk[number][1]+kkk[number][2]-1;
			
			int w = Math.min(endx-startx, endy-starty);
			
			//돌려
			for(int i = 0; i < w/2; i++) {
				
				int rx = startx;
				int ry = starty;
				
				int temp = arr[startx][starty];
				
				for(int k = 0; k < 4; k++) {
					while(true) {
						
						rx = rx+dx[k];
						ry = ry+dy[k];
						
						if(rx < startx || rx > endx || ry < starty || ry > endy) {
							rx = rx-dx[k];
							ry = ry-dy[k];
							break;
						} else {
							arr[rx-dx[k]][ry-dy[k]] = arr[rx][ry];
						}
					}
				}
				arr[startx][starty+1] = temp;
				startx++;
				starty++;
				endx--;
				endy--;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum = sum + arr[i][j];
					sb.append(arr[i][j]+" ");
				}
//				min = Math.min(min, sum);
				sb.append("\n");
			}
			System.out.println(sb);
//			System.out.println(min);

		}

//	}

	public static void re(int[] johap, int[] johapsel, boolean[] v, int idx, int[][] tmp) {
		if(idx == johapsel.length) {
			for(int number : johapsel) {
				dola(number, arr);
			}
			for(int i = 0; i < arr.length; i++) {
				int sum = 0;
				for(int j = 0; j < arr[0].length; j++) {
					sum = sum + arr[i][j];
				}
				min = Math.min(min, sum);
			}
			for(int i = 0; i < tmp.length; i++)
	            System.arraycopy(tmp[i], 0, arr[i], 0, tmp[0].length);
			return;
		}
		
		for(int i = 0; i < johap.length; i++) {
			if(!v[i]) {
				v[i] = true;
				johapsel[idx] = johap[i];
				re(johap, johapsel, v, idx+1, tmp);
				v[i] = false;
			}
		}
	}
}
