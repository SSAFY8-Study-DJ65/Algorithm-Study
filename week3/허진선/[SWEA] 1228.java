import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1228 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			LinkedList<Integer> code = new LinkedList<>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				code.add(sc.nextInt());
			}

			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				String temp = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j = 0; j < y; j++) {
					code.add(x, sc.nextInt());
					x++;
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(code.get(i) + " ");
			}
			System.out.println();
		}
	}
}
