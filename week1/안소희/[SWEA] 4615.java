import java.util.Scanner;

public class ocelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		//test_case 만큼 반복
		for(int tc=1;tc<=T;tc++) {
			//배열의  크기 N, 턴 수 M
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			//배열 생성
			int [][] map=new int[N][N];
			
			//맵 중앙에 각 돌 배치
			map[N/2-1][N/2-1]=2;
			map[N/2-1][N/2]=1;
			map[N/2][N/2-1]=1;
			map[N/2][N/2]=2;
			
			//돌 놓기 구현
			for(int i=0;i<M;i++) {
				int y=sc.nextInt()-1;
				int x=sc.nextInt()-1;
				int c=sc.nextInt();
				//돌을 놓고 난 후 사이에 낀 돌들을 변경
				map[y][x]=c;
				int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
				 //방향을 잡아줄 벡터
				for(int [] d:dir) {
					int j=1;
					while(true) {
						int n_x=x+d[1]*j;
						int n_y=y+d[0]*j;
						j++;
						
						if(n_x<0||n_x>=N||n_y<0||n_y>=N||map[n_y][n_x]==0)
							break;
						if(map[n_y][n_x]==c) {
							//같은 색의 돌을 만났을 때
							for(int k=1;k<j;k++) {
								//사이 돌 색 바꿔주기
								map[y+d[0]*k][x+d[1]*k]=c;
							}
							break;
						}
					}
				}
			}
			//돌 갯수 세기
			int b_stone=0;
			int w_stone=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1) {
						b_stone++;
					}
					else if(map[i][j]==2) {
						w_stone++;
					}
				}
			}
			System.out.println("#"+tc+" "+b_stone+" "+w_stone);
			/*제대로 변했는지 체크
			 * for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(map[j][i]);
				}
				System.out.println();
			}*/
			
		}

	}

}
