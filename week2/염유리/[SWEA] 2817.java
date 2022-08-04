import java.util.Scanner;

public class Solution {

	static int k, answer;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			k = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			answer = 0;
			
			fun(arr, new boolean[arr.length], 0, 0);
			
			System.out.println("#" + t + " " + answer);
		}

	}

	private static void fun(int[] arr, boolean[] v, int idx, int kk) {
		
		if(idx == arr.length) {
			int sum = 0;
			for(int i=0; i<v.length; i++) {
				if(v[i]) {
					sum += arr[i];
				}
			}
			if(sum == k) {
				answer++;
			}
			return;
		}
		
		v[idx] = true;
		fun(arr, v, idx+1, kk+1);
		
		v[idx] = false;
		fun(arr, v, idx+1, kk);
	}
}

/*

import java.util.Scanner;

class Solution {
    static int n, k, cnt;
    static int[] nums;
    static boolean[] check;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T ; t++) {

            n = sc.nextInt();
            k = sc.nextInt();

            cnt = 0;
            nums = new int[n];
            check = new boolean[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            dfs(0, 0);

            System.out.println("#" + t + " " + cnt);
        }
    }

    static void dfs(int depth, int sum){
        if(sum == k){
            cnt++;
            return;
        }
        
        if(depth == n) return;

        dfs(depth+1, sum);
        dfs(depth+1, sum+nums[depth]);
    }
}

*/
