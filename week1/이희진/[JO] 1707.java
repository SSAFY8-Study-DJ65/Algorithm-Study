import java.util.Scanner;

public class jo1707 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (!(n <= 100 && n > 0))
			System.out.println("INPUT ERROR!");
		else {
			int[][] arr = new int[n][n];

			int cnt = 0;
			int x = 0;
			int y = 0;
			int num = 1;
			int right = n;
			int bottom = n-1;

			if (n == 2)
				cnt = 1;
			else
				cnt = n / 2 + 1;

			while (cnt > 0) {
				for(int i = 0; i < right; i++) {
					arr[x][y] = num;
					num++;
					y++;
				}
				right--;
				y--;
				x++;
				
				for(int i = 0; i < bottom; i++) {
					arr[x][y] = num;
					num++;
					x++;
				}
				bottom--;
				x--;
				y--;
				
				for(int i = 0; i < right ; i++) {
					arr[x][y] = num;
					num++;
					y--;
				}
				right--;
				y++;
				x--;
				
				for(int i = 0; i < bottom; i++) {
					arr[x][y] = num;
					num++;
					x--;
				}
				bottom--;
				x++;
				y++;
				cnt--;
			}
			for(int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
					}
				System.out.println();
			}

		}

	}
}
