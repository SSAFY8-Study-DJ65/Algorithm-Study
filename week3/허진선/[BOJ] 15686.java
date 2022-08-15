import java.util.Scanner;

public class BOJ_15686 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		home = new int[2 * n][2];
		size_h = 0;
		store = new int[13][2];
		size_s = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				if (temp == 1) {
					home[size_h][0] = i;
					home[size_h][1] = j;
					size_h++;
				} else if (temp == 2) {
					store[size_s][0] = i;
					store[size_s][1] = j;
					size_s++;
				}
			}
		}
		r(0, 0, new boolean[size_s]); // 조합
		System.out.println(min);
	}

	static int n, m, size_h, size_s, min;
	static int[][] home, store;

	private static void r(int index, int count, boolean[] sel) {
		//System.out.println(index+" "+count+" "+Arrays.toString(sel));
		if (count > m) {
			//System.out.println("return");
			return;
		}
		else if (count > 0) {
			int[] len = new int[size_h];
			for (int i = 0; i < size_h; i++) {
				len[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < sel.length; i++) {
				if(sel[i] == true) { // 장사할 치킨집 선정
					for (int j = 0; j < size_h; j++) { // 집 개수 만큼 치킨 거리 계산
						int temp_len = Math.abs(home[j][0]-store[i][0])+Math.abs(home[j][1]-store[i][1]);
						len[j] = Math.min(len[j], temp_len);
					}
				}
			}
			int sum = 0;
			for (int l : len) {
				if(l!=Integer.MAX_VALUE)
					sum += l;
			}
			min = Math.min(min, sum);
			//System.out.println(Arrays.toString(len)+" "+sum+" "+min);
		}
		
		for (int i = index; i < size_s; i++) { // 장사할 치킨집 선정
			sel[i] = true;
			r(i + 1, count + 1, sel);
			sel[i] = false;
		}
	}
}
