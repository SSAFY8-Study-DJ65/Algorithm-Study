import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_5432 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			char[] arr = s.toCharArray();
			int stick = 0;
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == '(') stick++;
				else // arr[i] == ')'
				{
					stick--;
					if(arr[i-1] == '(') cnt += stick;
					else cnt++;
				}
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}
}
