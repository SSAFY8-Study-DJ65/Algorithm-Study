import java.util.Scanner;

public class BOJ_01244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] swi = new int[N+1];
		for (int i = 1; i <= N; i++) {
			swi[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int num = sc.nextInt();
			
			if (s == 1) {	//남학생
				for (int j = num; j <= N; j += num) {
					if (swi[j] == 0) {
						swi[j] = 1;
					} else {
						swi[j] = 0;
					}
				}
				
			} else if (s == 2) {	//여학생
				if (swi[num] == 0) {
					swi[num] = 1;
				} else {
					swi[num] = 0;
				}
				int left = num, right = num;
				while (true) {
					left--;
					right++;
					if (left <= 0 || right > N || swi[left] != swi[right])
						break;
					
					if (swi[left] == 0) {
						swi[left] = 1;
						swi[right] = 1;
					} else {
						swi[left] = 0;
						swi[right] = 0;
					}
				}	
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(swi[i] + " ");
			if (i%20 == 0)
				System.out.println();
		}
		sc.close();
	}

}
