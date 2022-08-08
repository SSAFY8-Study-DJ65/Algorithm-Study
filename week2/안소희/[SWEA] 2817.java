import java.util.Scanner;

public class Solution {
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			int[] arr=new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			
			recursive(arr,0,0,K);
			System.out.printf("#%d %d\n",tc,cnt);
            cnt=0;
		}
	}
	private static void recursive(int[] arr, int idx,int sum, int K) {
		// TODO Auto-generated method stub
		if(idx==arr.length) {
			if(sum==K) cnt++;
			return;
		}
		//더하기
		recursive(arr,idx+1,sum+arr[idx],K);
		
		//안더하기
		recursive(arr,idx+1,sum,K);
		
	}

}
