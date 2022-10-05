import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * S1
 * 2468 - 안전 영역
 * https://www.acmicpc.net/problem/2468
 */
public class Main {

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n;
    private static int[][] map;
    private static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        for (int h = 1; h <= maxHeight; h++) {
            bfsAll(h);
        }

        System.out.println(ans);
    }

    private static void bfsAll(int height) {
        boolean[][] v = new boolean[n][n];

        int area = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!v[y][x] && map[y][x] > height) {
                    v[y][x] = true;
                    bfs(v, new Pos(y, x), height);
                    area++;
                }
            }
        }

        ans = Math.max(ans, area);
    }

    private static void bfs(boolean[][] v, Pos start, int height) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(start);

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int[] d : dir) {
                int ny = now.y + d[0];
                int nx = now.x + d[1];

                if (checkRange(ny, nx) && !v[ny][nx] && map[ny][nx] > height) {
                    v[ny][nx] = true;
                    q.add(new Pos(ny, nx));
                }
            }
        }
    }

    private static boolean checkRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}