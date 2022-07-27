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
            int pre = sc.nextInt();
            int up = 0, down = 0;
            for (int i = 1; i < n; i++) {
                int now = sc.nextInt();
                int diff = now - pre;

                up = Math.max(up, diff);
                down = Math.min(down, diff);
                pre = now;
            }

            System.out.printf("#%d %d %d\n", tc, up, -1 * down);
        }
    }
}