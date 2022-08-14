import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			int sum = 0;
			int num = 0;
			for(int i=n-1; i>=0; i--) {
				
				if(num == 2) {
					num = 0;
					continue;
				}
				sum += arr[i];
				num++;
			}
			
			System.out.println("#" + t + " " + sum);
		}

	}

}
