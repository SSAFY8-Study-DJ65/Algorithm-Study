import java.util.Scanner;

public class s12564 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int w = sc.nextInt();
		
		int N = sc.nextInt();
		
		int [] dis = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			int dir = sc.nextInt();
			switch (dir) {
			
			//북
			case 1:
				dis[i] = sc.nextInt();
				break;
				
			//남
			case 2:
				dis[i] = w+l+w-sc.nextInt();
				break;
			
			//서
			case 3: 
				dis[i] = w+l+w+l-sc.nextInt();
				break;
				
			//동
			case 4:
				dis[i] = w+sc.nextInt();
				break;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int in = Math.abs(dis[N]-dis[i]);
			int out = 2*(w+l) - in;
			sum = sum+Math.min(in, out);
		}
		
		System.out.println(sum);
		
	}

}
