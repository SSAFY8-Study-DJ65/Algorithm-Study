import java.util.Scanner;

public class SWEA_1289 { // 원재의 메모리 복구하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String correct = sc.next();
			char[] arr = new char[correct.length()];
			for (int i = 0; i < correct.length(); i++) arr[i] = '0';

			int cnt = 0;
			for (int i = 0; i < correct.length(); i++) {
				if(correct.equals(new String(arr))) break;
				else if(correct.charAt(i)== arr[i]) continue;
				else 
				{
					char b_value = '1';
					if(correct.charAt(i) == '1') b_value = '1';
					else b_value = '0';
					for (int j = i; j < arr.length; j++) {
						arr[j] = b_value;
					}
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}
