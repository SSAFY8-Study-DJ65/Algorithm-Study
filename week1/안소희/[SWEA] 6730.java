import java.util.Scanner;

public class swea6730 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n=sc.nextInt();
			int[] height=new int[n];
			
			for(int i=0;i<n;i++) {
				height[i]=sc.nextInt();
			}
			
			int up_diff=0,down_diff=0;
			
			for(int i=0;i<n-1;i++) {
				if(height[i]<height[i+1]) {
					up_diff=Math.max(up_diff, height[i+1]-height[i]);
				}
				else if(height[i]>height[i+1]) {
					down_diff=Math.max(down_diff,height[i]-height[i+1]);
				}
			}
			
			System.out.println("#"+tc+" "+ up_diff+" "+down_diff);
		}
	}
}
