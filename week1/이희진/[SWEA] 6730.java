import java.util.Scanner;

public class d36730 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int [] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			
			int a = arr[0];
			int up = 0;
			int down = 0;
			
			for (int j = 0; j < n; j++) {
				if(a > arr[j]) {
					int sub = a -arr[j];
					down = Math.max(sub, down);
				} else {
					int sub = arr[j]-a;
					up = Math.max(sub, up);
				}
				a = arr[j];
			}
			
			System.out.println("#"+(i+1)+" " + up + " " + down);
		}

	}

}
