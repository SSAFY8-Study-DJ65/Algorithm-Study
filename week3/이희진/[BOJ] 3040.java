import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b23040 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = new int[9];
		int[] sel = new int[7];
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}			
//		System.out.println(Arrays.toString(arr));
		re(arr, sel, 0, 0);
	}
	
	private static void re(int[] arr, int[] sel, int idx, int k) {
		// TODO Auto-generated method stub
		
		if(k == sel.length) {
			int sum = 0;
			for(int number : sel) {
				sum += number; 
			}
//			System.out.println(sum);
			if (sum == 100) {
				for(int number : sel) {
					System.out.println(number);
				}
			}
			return;
		}
		
		for(int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			re(arr, sel, i+1, k+1);			
		}
	}
}
