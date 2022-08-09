package m08w2;
/*
 * SWEA : 1228 D3 암호문1
 */
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_01228 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			int C = sc.nextInt();
			for (int i = 0; i < C; i++) {
				String com = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for (int j = 0; j < y; j++) {
					list.add(x++, sc.nextInt());
				}
				
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.poll() + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
