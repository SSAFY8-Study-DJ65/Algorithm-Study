
import java.util.Scanner;

// swea 1289 원재의 메모리 복구하기
public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			char[] input = sc.next().toCharArray();
			
			char[] origin = new char[input.length];
			
			for(int i=0; i<input.length; i++) {
				origin[i] = '0';
			}
			
			int cnt = 0;
			
			for(int i=0; i<input.length; i++) {
				if(input[i] != origin[i]) {
					cnt++;
					for(int j=i; j<input.length; j++) {
						origin[j] = input[i];
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}

}
