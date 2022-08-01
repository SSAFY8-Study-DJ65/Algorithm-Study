import java.util.Scanner;

public class jungol1707 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] arr=new int[n][n];
		int num=1;
		int m=n; //한 번에 적히는 숫자 수
		int x=0,y=-1; //좌표
		while(m>0) {
			// ->
			for(int i=0;i<m;i++) {
				y++;
				arr[x][y]=num++;
			}
			m--;
			//아래
			for(int i=0;i<m;i++) {
				x++;
				arr[x][y]=num++;
			}
			//<-
			for(int i=0;i<m;i++) {
				y--;
				arr[x][y]=num++;
			}
			m--;
			//위
			for(int i=0;i<m;i++) {
				x--;
				arr[x][y]=num++;
			}
			
		}
		
		for(int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
