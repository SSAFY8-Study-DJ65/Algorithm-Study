import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			int upmax = 0;
			int downmax = 0;
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<n-1; i++) {
				if(arr[i] < arr[i+1]) {
					upmax = Math.max(upmax, arr[i+1] - arr[i]);
				}else if(arr[i] > arr[i+1]) {
					downmax = Math.max(downmax, arr[i] - arr[i+1]);
				}
			}
			
			System.out.println("#" + t + " " + upmax + " " + downmax);
			
		}
	}

}
