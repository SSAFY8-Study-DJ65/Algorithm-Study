import java.util.Scanner;

public class SWEA_1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			String memory = sc.next();
			int res = 0;
			char bit = '0';
			
			for (int i = 0; i < memory.length(); i++) {
				if (memory.charAt(i) != bit) {
					if (bit == '0') {
						bit = '1';
					} else {
						bit = '0';
					}
					res++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

}
