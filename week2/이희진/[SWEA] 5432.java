import java.util.Scanner;

public class d45432 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i < T+1; i++) {
			String str = sc.next();
			int cnt = 0;
			int sum = 0;
			
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(' && str.charAt(j+1) == ')') {
					sum = sum + cnt;
					j++;
				} else if (str.charAt(j) == '(') cnt++;
				else {
					cnt--;
					sum++;
				}
			}
			System.out.println("#"+i+" "+sum);
		}
	}
}
