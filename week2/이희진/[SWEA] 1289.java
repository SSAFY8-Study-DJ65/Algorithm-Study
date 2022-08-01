import java.util.Scanner;

public class d31289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i < T+1; i++) {
			String str = sc.next();
			
			char [] c = new char[str.length()];
			char [] ini = new char[str.length()];
			
			for(int j = 0; j < c.length; j++) {
				c[j] = str.charAt(j);
				ini[j] = '0';
			}
			
			int cnt = 0;
			
			for (int j = 0; j < c.length; j++) {
				if(c[j] != ini[j]) {
					for(int k = j; k < c.length; k++) {
						ini[k] = c[j];
					}
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
