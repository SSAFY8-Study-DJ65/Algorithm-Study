package m08w2;
/*
 * BOj : 3040 B2 백설 공주와 일곱 난쟁이
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_03040 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			num.add(sc.nextInt());
		}
		
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += num.get(i);
		}
		
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if (sum-num.get(i)-num.get(j) == 100) {
					num.remove(j);
					num.remove(i);
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		
		for (int i = 0; i < 7; i++) {
			System.out.println(num.get(i));
		}
	}

}
