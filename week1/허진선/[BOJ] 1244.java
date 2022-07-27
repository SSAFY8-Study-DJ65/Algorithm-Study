import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_1244 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int s = sc.nextInt();
			int num = sc.nextInt();
			if(s==1) // 남학생이면
			{
				int temp = num;
				while(num<=n)
				{
					arr[num] = (arr[num] == 1) ? 0 : 1;
					num += temp;
				}
			}
			else // 여학생이면
			{
				arr[num] = (arr[num] == 1) ? 0 : 1;
				
				int len = Math.min(n-num, num-1);
				for (int j = 1; j <= len; j++) {
					if(arr[num+j]==arr[num-j]) {
						arr[num+j] = (arr[num+j] == 1) ? 0 : 1;
						arr[num-j] = (arr[num-j] == 1) ? 0 : 1;
					}
					else break;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) System.out.println();
		}
		System.out.println();
	}
}
