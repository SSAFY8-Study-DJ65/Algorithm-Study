import java.util.Scanner;

/**
 * D3
 * 1289 - 원재의 메모리 복구하기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            char[] input = sc.next().toCharArray();
            int[] origin = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                origin[i] = input[i] - '0';
            }

            System.out.printf("#%d %d\n", tc, recur(origin, 0, 0));
        }
    }

    private static int recur(int[] origin, int idx, int lastElem) {
        int len = origin.length;
        if (idx == len) return 0;

        int ret = 0;
        for (int i = idx; i < len; i++) {
            if (origin[i] != lastElem) {
                lastElem = (lastElem + 1) % 2;
                ret = 1 + recur(origin, i, lastElem);
                break;
            }
        }

        return ret;
    }
}