import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int n,m;
	static int res=1;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(str.nextToken());
		m=Integer.parseInt(str.nextToken());
		
		map=new int[n][m];
		visited= new boolean[n][m];
		str=new StringTokenizer(br.readLine());
		int robot_r=Integer.parseInt(str.nextToken());
		int robot_c=Integer.parseInt(str.nextToken());
		int dir=Integer.parseInt(str.nextToken());
		
		for(int i=0;i<n;i++) {
			str=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(str.nextToken());
			}
		}
		visited[robot_r][robot_c]=true;
		cleaning(robot_r,robot_c,dir);
		//print(map);

	}

	private static void cleaning(int robot_r, int robot_c, int dir) {
		for(int i=0;i<4;i++) {
			int n_dir=(dir+3-i)%4;
			int rr=robot_r+dr[n_dir];
			int cc=robot_c+dc[n_dir];
			//벽이거나 맵 바깥이면 회전
			if(map[rr][cc]==1 || rr<0 || rr>=n || cc<0 || cc>=m) continue;
			
			if(map[rr][cc]==0 && !visited[rr][cc]) {
				visited[rr][cc]=true;
				res++;
				cleaning(rr, cc, n_dir);
			}
		}
		
		//후진 체크
		int n_dir=(dir+2)%4;
		int rr= robot_r+dr[n_dir];
		int cc= robot_c+dc[n_dir];
		if(map[rr][cc]==0) {
			//후진 가능
			//방향 유지
			cleaning(rr, cc, dir);
		}
		else {
			System.out.println(res);
			//작동 멈추기
			System.exit(0);
		}
		
	}

	private static void print(int[][] map2) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
	}

}
