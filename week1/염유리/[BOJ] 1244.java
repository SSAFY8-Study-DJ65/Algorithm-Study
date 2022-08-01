
import java.util.Arrays;
import java.util.Scanner;

// S3 스위치 켜고 끄기
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] switches = new int[n];
		
		for(int i=0; i<n; i++) {
			switches[i] = sc.nextInt();
		}
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int st = sc.nextInt();
			int num = sc.nextInt();
			
			if(st == 1) { // num의 배수만 바꾼다
				for(int j=0; j<n; j++) {
					if((j+1) % num == 0) {
						switches[j] = switches[j] == 1 ? 0 : 1;
					}
				}
			}
			else if(st == 2) { // num으로부터 좌우 대칭인 것만 바꾼다
			  int len = 1;
				
				switches[num-1] = switches[num-1] == 1 ? 0 : 1;
				
				int left = num-1-len;
				int right = num-1+len;
				
				while((left >= 0 && left < n && right >= 0 && right < n)
						    && switches[left] == switches[right]) {
					switches[left] = switches[left] == 1 ? 0 : 1;
					switches[right] = switches[right] == 1 ? 0 : 1;
					len++;
					left = num-1-len;
					right = num-1+len;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(switches[i] + " ");
			if((i+1) % 20 == 0) System.out.println();
		}
	}

}
