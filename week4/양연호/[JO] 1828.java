package m08w3;
/*
 * JO : 1828 IM 냉장고
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO_01828 {

	static int N, res, max;
	static ArrayList<Temperature> temp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		temp = new ArrayList<>();
		int min_temp;
		int max_temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			min_temp = Integer.parseInt(st.nextToken());
			max_temp = Integer.parseInt(st.nextToken());
			temp.add(new Temperature(min_temp, max_temp));
		}
		Collections.sort(temp);
		
		res = 1;
		max = temp.get(0).max_temp;
		for (int i = 1; i < N; i++) {
			if (max < temp.get(i).min_temp) {
				max = temp.get(i).max_temp;
				res++;
			}
		}
		
		System.out.println(res);
		
	}
	
	static class Temperature implements Comparable<Temperature> {

		int min_temp;
		int max_temp;
		
		public Temperature(int min_temp, int max_temp) {
			this.min_temp = min_temp;
			this.max_temp = max_temp;
		}
		
		@Override
		public int compareTo(Temperature o) {
			return this.max_temp - o.max_temp;
		}
		
	}

}
