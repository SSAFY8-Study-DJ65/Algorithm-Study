import java.util.Scanner;

public class SWEA_05432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String pipe = sc.next();
			int cnt = 0;
			int res = 0;
			
			for (int i = 1; i < pipe.length(); i++) {
				char p = pipe.charAt(i);
				
				if (p == '(') {
					if (pipe.charAt(i-1) == '(') {
						cnt += 1;
					}
				} else {
					if (pipe.charAt(i-1) == '(') {
						res += cnt;
					} else {
						res++;
						cnt--;
					}
				}
			}
			System.out.println("#" + tc + " " + res);
			
		}
	}

}
