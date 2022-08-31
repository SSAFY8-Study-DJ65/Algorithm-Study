import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int[] arr = new int[w];
		
		for(int i=0; i<w; i++) {
			arr[i] = sc.nextInt();
		}
		
		int left = -1;
		int right = -1;
		int ans = 0;
		// 한칸마다 왼쪽 제일 큰거, 오른쪽제일큰거, 둘중 작은거만큼 채운다
		for(int i=1; i<w-1; i++) {
			left =i-1; right=i+1;
			
			for(int j=i-1; j >= 0; j--) {
				if(arr[left] < arr[j]) {
					left = j;
				}
			}
			
			for(int j=i+1; j < w; j++) {
				if(arr[right] < arr[j]) {
					right = j;
				}
			}
			if(arr[i] >= arr[left] || arr[i] >= arr[right]) continue;
			if(arr[left] == 0 || arr[right] == 0) {
				break;
			}
			
			
			ans += Math.min(arr[left], arr[right]) - arr[i];
			arr[i] = Math.min(arr[left], arr[right]);
		}
		
		System.out.println(ans);

	}

}
