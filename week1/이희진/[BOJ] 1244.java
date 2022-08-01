import java.util.Scanner;

public class s31244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int [] arr = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			arr[i] = sc.nextInt();
		}
		
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int a = sc.nextInt();
			switch (a) {
			case 1:
				int b = sc.nextInt();
				int bb = b;
				while(b <= N) {
					if(arr[b] == 0) {
						arr[b] = 1;
						b = b+bb;
					} else {
						arr[b] = 0;
						b= b + bb;
					}
				}
				break;

			case 2:
				b = sc.nextInt();
				bb = b;
				int start = b;
				int end = b;
				while(true) {
					if(bb-1 >= 1 && b+1 < N+1 && arr[bb-1] == arr[b+1]) {
						start = bb-1;
						end = b+1;
						bb--;
						b++;
					} else break;
				}
				for(int j = start; j <= end; j++) {
					if(arr[j] == 0) arr[j] = 1;
					else arr[j] = 0;
				}
				break;
			}
		}
		for(int i = 1; i < N+1; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0) System.out.println();
		}
	}
}
