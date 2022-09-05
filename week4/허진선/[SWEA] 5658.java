package week4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_5658 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String s = br.readLine();

			ArrayList<Character> nums = new ArrayList<Character>();
			for (int i = 0; i < n; i++) {
				nums.add(s.charAt(i));
			}
			for (int i = 0; i < (n / 4) - 1; i++) {
				nums.add(s.charAt(i));
			}

			ArrayList<Integer> arr = new ArrayList<>();
			StringBuilder pwd = new StringBuilder();
			for (int i = 0; i < n; i++) {
				for (int j = i; j < i + n / 4; j++)
					pwd.append(nums.get(j));

				int num = Integer.parseInt(pwd.toString(), 16);
				if (!arr.contains(num))
					arr.add(num);

				pwd.delete(0, pwd.length());
			}
			Collections.sort(arr, Collections.reverseOrder());
			sb.append("#").append(tc).append(" ").append(arr.get(k - 1)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
