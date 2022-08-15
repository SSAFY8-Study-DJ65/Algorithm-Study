import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int max=-1,n,m;
	static int[] weight;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer str= new StringTokenizer(br.readLine());
			n=Integer.parseInt(str.nextToken());
			m=Integer.parseInt(str.nextToken());
			
			weight=new int[n];
			str=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				weight[i]=Integer.parseInt(str.nextToken());
			}
			recursive(0,0,0);
			sb.append("#"+tc+" "+max+"\n");
			max=-1;
		}
		
		System.out.println(sb);
	}
	private static void recursive(int L, int sum,int idx) {
		// TODO Auto-generated method stub
		if(sum>m) return; //무게 초과
		if(L==2) {//두 봉지 다 고른 경우
			max=Math.max(max, sum);
			return;
		}
		if(idx==n) return;
		
		recursive(L+1,sum+weight[idx],idx+1);
		recursive(L,sum,idx+1);
	}

}
