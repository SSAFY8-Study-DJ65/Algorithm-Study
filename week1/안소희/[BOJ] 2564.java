import java.util.Scanner;


public class boj2564 {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);

		int n= sc.nextInt(); //가로 j

		int m= sc.nextInt(); //가로 j
		int [][] map = new int[m+1][n+1]; //지도 정보

		

		for(int i=0;i<=m;i++) {  

			for(int j=0;j<=n;j++) {
				map[i][j]=0;
			}
		}
		
		int store=sc.nextInt(); //상점의 갯수

		int total_dis=0; //각 상점까지의 최단거리들의 합 

		for(int i=0;i<store;i++) {
			int dir=sc.nextInt(); // 1:북=> i=0 2:남=>i=m 3:서=>j=0 4:동 j=n;
			int location=sc.nextInt(); //위치
			switch(dir) {
			case 1:
				map[0][location]=1;
				break;
			case 2:
				map[m][location]=1;
				break;
			case 3:
				map[location][0]=1;
				break;
			case 4:
				map[location][n]=1;
				break;
			}
		}
		int d_dir=sc.nextInt();
		int dg=sc.nextInt();
		
		//펼쳐서 선분의 길이 생각
		int cnt_store=0;
		
		for(int i=0;i<=m;i++) {
			if(cnt_store==store) break;
			for(int j=0;j<=n;j++) {
				if(map[i][j]==1) {
					cnt_store++;
					switch(d_dir) {
					case 1://동근이가 북쪽에  있을 때
						if(i==0) {
							total_dis+=Math.abs(j-dg);
						}
						else if(i==m) {
							total_dis+=Math.min(dg+m+j,2*n+m-j-dg);
						}
						else if(j==0) {
							total_dis+=dg+i;
						}
						else {
							total_dis+=n-dg+i;
						}
						break;
					case 2: //동근이가 남쪽에 있을 때
						if(i==0) {
							total_dis+=Math.min(dg+m+j,2*n+m-j-dg);
						}
						else if(i==m) {
							total_dis+=Math.abs(j-dg);
						}
						else if(j==0) {
							total_dis+=dg+m-i;
						}
						else {
							total_dis+=n-dg+m-i;
						}
						break;
					case 3: //동근이가 서쪽에 있을 때
						if(i==0) {
							total_dis+=dg+j;
						}
						else if(i==m) {
							total_dis+=m-dg+j;
						}
						else if(j==0) {
							total_dis+=Math.abs(i-dg);
						}
						else {
							total_dis+=Math.min(dg+n+i,2*m+n-i-dg);
						}
						break;
					case 4: //동근이가 동쪽에 있을 때
						if(i==0) {
							total_dis+=dg+n-j;
						}
						else if(i==m) {
							total_dis+=m-dg+n-j;
						}
						else if(j==0) {
							total_dis+=Math.min(2*m+n-dg-i,dg+n+i);
						}
						else {
							total_dis+=Math.abs(dg-i);
						}
						break;
					}
				}
			}
		}
		
		System.out.print(total_dis);
		

	}

}
