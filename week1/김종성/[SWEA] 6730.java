import java.util.Scanner;
 
/**
 * D3
 * 6730 - 장애물 경주 난이도
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWefy5x65PoDFAUh#none
 */
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }
 
            int up = 0, down = 0;
            for (int i = 0; i <= n - 2; i++) {
                int diff = height[i + 1] - height[i];
 
                if (diff > 0) {
                    up = Math.max(up, diff);
                } else {
                    down = Math.min(down, diff);
                }
            }
 
            System.out.printf("#%d %d %d\n", tc, up, -1 * down);
        }
    }
}