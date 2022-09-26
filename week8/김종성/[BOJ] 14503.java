import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * G5
 * 14503 - 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 */
public class Main {

    private static class Cleaner {
        int y;
        int x;
        int d;

        public Cleaner(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Cleaner cleaner = new Cleaner(r, c, d);
        map[r][c] = 2;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (true) {
            int cy = cleaner.y;
            int cx = cleaner.x;
            int cd = cleaner.d;

            if (map[cy][cx] == 0) {
                map[cy][cx] = 2;
                ans++;
            }

            boolean flag = false;
            for (int i = 1; i <= 4; i++) {
                int nd = (cd - i + 4) % 4;
                int ny = cy + dir[nd][0];
                int nx = cx + dir[nd][1];

                if (map[ny][nx] == 0) {
                    cleaner.y = ny;
                    cleaner.x = nx;
                    cleaner.d = nd;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                int ny = cy - dir[cd][0];
                int nx = cx - dir[cd][1];
                if (map[ny][nx] != 1) {
                    cleaner.y = ny;
                    cleaner.x = nx;
                } else break;
            }
        }

        System.out.println(ans);
    }
}