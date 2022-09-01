package week5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14719 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] arr = new int[h][w];
		for (int i = 0; i < w; i++) {
			int n = sc.nextInt();
			int idx = h - 1;
			while (n != 0) {
				arr[idx--][i] = 1;
				n--;
			}
		}
		// print(arr);
		int total = 0;
		for (int i = 0; i < h; i++) {
			int cnt = 0;
			boolean flag = false;
			for (int j = 0; j < w; j++) {
				if (!flag) { 
					if (arr[i][j] == 1) // 시작 벽 찾음
						flag = true; 
				} else {
					if (arr[i][j] == 1) { // 끝 벽 찾음
						total += cnt;
						cnt = 0;
					} else { // 빗물이 고임
						cnt++;
					}
				}
			}
		}
		System.out.println(total);
	}

	private static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}
