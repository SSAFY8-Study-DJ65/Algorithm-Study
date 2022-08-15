import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int idx = k-1;
		StringBuilder sb = new StringBuilder("<");
		while(true) {
			sb.append(list.get(idx));
			sb.append(", ");
			list.remove(idx);
			idx += k - 1;
			if(list.isEmpty()) break;
			idx %= list.size();
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
	}
}
