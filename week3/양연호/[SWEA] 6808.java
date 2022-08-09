package m08w2;
/*
 * SWEA : 6808 D3 규영이와 인영이의 카드게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_06808 {

	static int[] card;
	static int win;
	static int lose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			card = new int[9];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 9; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] check = new boolean[19];
			for (int i = 0; i < 9; i++) {
				check[card[i]] = true;
			}
			
			int[] card2 = new int[9];
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!check[i])
					card2[idx++] = i;
			}
			
			int[] sel = new int[9];
			boolean[] visited = new boolean[card2.length];
			win = 0;
			lose = 0;
			recur(card2, sel, 0, visited);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
	private static void recur(int[] card2, int[] sel, int idx, boolean[] visited) {
		if (idx == 9) {
			int g_total = 0;
			int i_total = 0;
			for (int i = 0; i < 9; i++) {
				if (card[i] > sel[i]) {
					g_total += card[i]+sel[i];
				} else if (card[i] < sel[i]){
					i_total += card[i]+sel[i];
				}
			}
			
			if (g_total > i_total) {
				win++;
			}
			else if (g_total < i_total) {
				lose++;
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				sel[idx] = card2[i];
				recur(card2, sel, idx+1, visited);
				visited[i] = false;
			}
		}
	}
	
	

}
