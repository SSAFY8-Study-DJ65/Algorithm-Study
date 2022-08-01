import java.util.Scanner;

public class swea1873 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int h=sc.nextInt();
			int w=sc.nextInt();
			char[][] map=new char[h][];
			int dir=0; // 현재 가리키고 있는 방향 정보
			for (int i = 0; i < h; i++) {
				String str=sc.next();
				map[i]=str.toCharArray();
			}
			int x=0,y=0; //전차의 위치정보
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j]=='^') {
						dir=1;
						x=i;
						y=j;
					}
					else if(map[i][j]=='v') {
						dir=2;
						x=i;
						y=j;
					}
					else if(map[i][j]=='<') {
						dir=3;
						x=i;
						y=j;
					}
					else if(map[i][j]=='>') {
						dir=4;
						x=i;
						y=j;
					}
				}
			}
			
			 
		
			int n=sc.nextInt();
			String str=sc.next();
			
			for(int i=0;i<n;i++) {
				char signal=str.charAt(i);
			
				if(signal=='U') { //위쪽을 보게하고 위칸이 평지면 이동
					dir=1;
					if(x-1>=0 && map[x-1][y]=='.') {
						map[x][y]='.'; //위치정보 저장 후 전차의 이동을 위해 평지로 바꿔줌
						x-=1; //위쪽으로 한 칸 이동
					}
					map[x][y]='^';
				}
				else if(signal=='D') {
					dir=2;
					if(x+1<h && map[x+1][y]=='.') {
						map[x][y]='.'; //위치정보 저장 후 전차의 이동을 위해 평지로 바꿔줌
						x+=1;
					}
					map[x][y]='v';
				}
				else if(signal=='L') {
					dir=3;
					if(y-1>=0 && map[x][y-1]=='.') {
						map[x][y]='.'; //위치정보 저장 후 전차의 이동을 위해 평지로 바꿔줌
						y-=1;
					}
					map[x][y]='<';
				}
				else if(signal=='R') {
					dir=4;
					if(y+1<w && map[x][y+1]=='.') {
						map[x][y]='.'; //위치정보 저장 후 전차의 이동을 위해 평지로 바꿔줌
						y+=1;
						
					}
					map[x][y]='>';
				}
				else if(signal=='S') {
					switch(dir){
						case 1: //위로
							for(int j=x-1;j>=0;j--) {
								if(map[j][y]=='*'||map[j][y]=='#') {
									if(map[j][y]=='*') map[j][y]='.';
									break;
								}
							}
							break;
						case 2: //아래로
							for(int j=x+1;j<h;j++) {
								if(map[j][y]=='*'||map[j][y]=='#') {
									if(map[j][y]=='*') map[j][y]='.';
									break;
								}
							}
							break;
						case 3: //왼쪽
							for(int j=y-1;j>=0;j--) {
								if(map[x][j]=='*'||map[x][j]=='#') {
									if(map[x][j]=='*') map[x][j]='.';
									break;
								}
							}
							break;
						case 4: //오른쪽
							for(int j=y+1;j<w;j++) {
								if(map[x][j]=='*'||map[x][j]=='#') {
									if(map[x][j]=='*') map[x][j]='.';
									break;
								}
							}
							break;
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
