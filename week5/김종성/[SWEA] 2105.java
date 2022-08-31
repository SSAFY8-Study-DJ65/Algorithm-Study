import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 모의 SW 역량테스트
 * 2105 - 디저트 카페
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu
 */
public class Solution {

    private static final int[][] dir = {{1, -1}, {1, 1}};
    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = -1;
            for (int y = 0; y < n - 2; y++) {
                for (int x = 1; x < n - 1; x++) {
                    ans = Math.max(ans, dfs(y, x, getMaxLength(y, x, dir[0]), getMaxLength(y, x, dir[1])));
                }
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    private static int getMaxLength(int y, int x, int[] d) {
        int len = -1;
        while (checkPoint(y, x)) {
            y += d[0];
            x += d[1];
            len++;
        }

        y -= d[0];
        x -= d[1];
        if (y == n - 1 && (x == 0 || x == n - 1))
            len--;

        return len;
    }

    private static int dfs(int y, int x, int a, int b) {
        int ret = -1;
        if (a == 0 || b == 0) return ret;

        if (checkRange(y, x, a, b)) {
            ret = validate(y, x, a, b);
        }

        if (ret == -1) {
            ret = Math.max(ret, dfs(y, x, a - 1, b));
            ret = Math.max(ret, dfs(y, x, a, b - 1));
        }

        return ret;
    }

    private static boolean checkRange(int y, int x, int a, int b) {
        int ly = y + a * dir[0][0];
        int lx = x + a * dir[0][1];
        int ry = y + b * dir[1][0];
        int rx = x + b * dir[1][1];
        int dy = ly + b * dir[1][0];
        int dx = lx + b * dir[1][1];

        return checkPoint(ly, lx) && checkPoint(ry, rx) && checkPoint(dy, dx);
    }

    private static boolean checkPoint(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }

    private static int validate(int y, int x, int a, int b) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= a; i++) {
            int tempY = y + i * dir[0][0];
            int tempX = x + i * dir[0][1];
            int temp = map[tempY][tempX];

            int pairY = tempY + b * dir[1][0];
            int pairX = tempX + b * dir[1][1];
            int pair = map[pairY][pairX];

            if (temp != pair && !set.contains(temp) && !set.contains(pair)) {
                set.add(temp);
                set.add(pair);
            } else {
                return -1;
            }
        }

        for (int i = 1; i < b; i++) {
            int tempY = y + i * dir[1][0];
            int tempX = x + i * dir[1][1];
            int temp = map[tempY][tempX];

            int pairY = tempY + a * dir[0][0];
            int pairX = tempX + a * dir[0][1];
            int pair = map[pairY][pairX];

            if (temp != pair && !set.contains(temp) && !set.contains(pair)) {
                set.add(temp);
                set.add(pair);
            } else {
                return -1;
            }
        }

        return set.size();
    }
}
