import java.util.ArrayList;
import java.util.Scanner;

public class sw1228 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i = 0; i < N; i++) {
				arr.add(sc.nextInt());
			}
			
			int I = sc.nextInt();
			
			for(int i = 0 ; i < I; i++) {
				sc.next();
				int w = sc.nextInt();
				
				int a = sc.nextInt();
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				
				for(int j = 0; j < a; j++) {
					arr.add(w++, sc.nextInt());
				}
			}
			System.out.print("#"+tc+" ");
			for(int i = 0; i < 10; i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
		}
	}
}
