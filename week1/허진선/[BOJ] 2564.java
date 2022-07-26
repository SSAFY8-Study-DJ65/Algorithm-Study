import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2564 { // 경비원

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // 가로
		int n = sc.nextInt(); // 세로
		int cnt = sc.nextInt(); // 상점의 개수
		
//		2차원 지도의 테두리를 1차원 선으로 변환
		int[] pos = new int[cnt+1];
		for (int i = 0; i <= cnt; i++) {
			int dir = sc.nextInt(); // 방향
			int dist = sc.nextInt(); // 거리
			
			if(dir == 1) pos[i] = m-dist; // 북
			else if(dir == 3) pos[i] = m+dist; //서
			else if(dir == 2) pos[i] = m+n+dist; // 남
			else pos[i] = m+n+m+n-dist; // 동
		}
		
		int sum = 0;
		for (int i = 0; i < cnt; i++) {
			int len1 = Math.abs(pos[cnt]-pos[i]);
			int len2 = 2*m+2*n - len1;
			sum += Math.min(len1, len2);
		}
		System.out.println(sum);
	}
}
