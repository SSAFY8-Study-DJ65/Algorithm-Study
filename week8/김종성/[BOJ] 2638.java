import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * G3
 * 2638 - 치즈
 * https://www.acmicpc.net/problem/2638
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

    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int n, m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setOutdoor();

        LinkedList<Pos> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 1 && getContactSurfaceCount(y, x) >= 2) {
                    v[y][x] = true;
                    q.add(new Pos(y, x));
                }
            }
        }

        System.out.println(melt(q, v));
    }

    private static void setOutdoor() {
        boolean[][] v = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 0 && !v[y][x]) {
                    bfs(new Pos(y, x), v);
                }
            }
        }
    }

    private static void bfs(Pos start, boolean[][] v) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(start);
        v[start.y][start.x] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int[] d : dir) {
                int ny = cur.y + d[0];
                int nx = cur.x + d[1];

                if (checkRange(ny, nx) && map[ny][nx] == 0) {
                    map[ny][nx] = -1;
                    q.add(new Pos(ny, nx));
                }
            }
        }
    }

    private static boolean checkRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    private static int getContactSurfaceCount(int y, int x) {
        int cnt = 0;
        for (int[] d : dir) {
            int ny = y + d[0];
            int nx = x + d[1];

            if (checkRange(ny, nx) && map[ny][nx] == -1) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int melt(LinkedList<Pos> q, boolean[][] v) {
        int time = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            time++;

            for (int i = 0; i < qSize; i++) {
                Pos cur = q.poll();
                map[cur.y][cur.x] = -1;

                for (int[] d : dir) {
                    int ny = cur.y + d[0];
                    int nx = cur.x + d[1];

                    if (checkRange(ny, nx) && !v[ny][nx] && map[ny][nx] == 1 && getContactSurfaceCount(ny, nx) > 1) {
                        v[ny][nx] = true;
                        q.add(new Pos(ny, nx));
                    }
                }
            }
        }

        return time;
    }
}