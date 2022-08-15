import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d36808 {
	
	static int win;
	static int lose;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			win = 0;
			lose = 0;
			
			int gyu[] = new int[9];
			int gyutmp[] = new int[9];
			//원본
			int in[] = new int[9];
			//선택
			int sel[] = new int[9];
			// 선택 여부 판단
			boolean[] visit = new boolean[9];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				gyutmp[i] = gyu[i];
			}
			
			//인영 카드 배열
			Arrays.sort(gyutmp);
			
			int k = 0;
			int num = 0;
			for(int i = 1; i <= 18; i++) {
				if(i != gyutmp[num]) {
					in[k++] = i;
				} else {
					if(num+1<9) num++;
				}
			}
			recursive(in, gyu, sel, 0, visit);
			
			System.out.println("#"+ tc+" "+win + " " + lose);
		}
	}

	private static void recursive(int[] in, int[] gyu, int[] sel, int idx, boolean[] visit) {
		// basis part
		if (idx == sel.length) {
			int gyusum = 0;
			int insum = 0;
			// 다 뽑았어요
			for(int i = 0; i < 9; i++) {
				if(gyu[i] > sel[i]) {
					gyusum = gyusum + gyu[i] + sel[i];
				}
				else if(gyu[i] < sel[i]) {
					insum = insum + gyu[i] + sel[i];
				}
			}
			
			if(gyusum > insum) win++;
			else if(gyusum < insum) lose++;
			else if(gyusum == insum) return;
			return;
		}

		// logic part

		// inductive part

		for (int i = 0; i < 9; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				sel[idx] = in[i];
				recursive(in, gyu, sel, idx + 1, visit);
				visit[i] = false;
			}
		}
	}
}
