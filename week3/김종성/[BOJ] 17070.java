import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * G5
 * 17070 - 파이프 옮기기 1
 * https://www.acmicpc.net/problem/17070
 */
public class Main {

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static class Pipe {
        Position pos;
        int shape;

        public Pipe(Position pos, int shape) {
            this.pos = pos;
            this.shape = shape;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];

        for (int r = 1; r <= n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Pipe pipe = new Pipe(new Position(1, 2), 1);

        System.out.println(dfs(map, n, pipe));
    }

    private static int dfs(int[][] map, int n, Pipe pipe) {
        if (pipe.pos.y == n && pipe.pos.x == n)
            return 1;

        int ret = 0;
        if (pipe.shape == 1) {
            if (canGoLeft(map, n, pipe.pos)) {
                pipe.pos.x += 1;
                ret += dfs(map, n, pipe);
                pipe.pos.x -= 1;
            }

            if (canGoDiagonal(map, n, pipe.pos)) {
                pipe.pos.y++;
                pipe.pos.x++;
                pipe.shape = 3;
                ret += dfs(map, n, pipe);
                pipe.pos.y--;
                pipe.pos.x--;
                pipe.shape = 1;
            }
        } else if (pipe.shape == 2) {
            if (canGoDown(map, n, pipe.pos)) {
                pipe.pos.y++;
                ret += dfs(map, n, pipe);
                pipe.pos.y--;
            }

            if (canGoDiagonal(map, n, pipe.pos)) {
                pipe.pos.y++;
                pipe.pos.x++;
                pipe.shape = 3;
                ret += dfs(map, n, pipe);
                pipe.pos.y--;
                pipe.pos.x--;
                pipe.shape = 2;
            }
        } else {
            if (canGoLeft(map, n, pipe.pos)) {
                pipe.pos.x += 1;
                pipe.shape = 1;
                ret += dfs(map, n, pipe);
                pipe.pos.x -= 1;
                pipe.shape = 3;
            }

            if (canGoDown(map, n, pipe.pos)) {
                pipe.pos.y++;
                pipe.shape = 2;
                ret += dfs(map, n, pipe);
                pipe.pos.y--;
                pipe.shape = 3;
            }

            if (canGoDiagonal(map, n, pipe.pos)) {
                pipe.pos.y++;
                pipe.pos.x++;
                ret += dfs(map, n, pipe);
                pipe.pos.y--;
                pipe.pos.x--;
            }
        }

        return ret;
    }

    private static boolean canGoLeft(int[][] map, int n, Position pos) {
        int ny = pos.y;
        int nx = pos.x + 1;

        return checkRange(n, ny, nx) && map[ny][nx] == 0;
    }

    private static boolean canGoDiagonal(int[][] map, int n, Position pos) {
        int[][] dir = {{0, 1}, {1, 1}, {1, 0}};
        for (int[] d : dir) {
            int ny = pos.y + d[0];
            int nx = pos.x + d[1];

            if (!checkRange(n, ny, nx) || map[ny][nx] != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean canGoDown(int[][] map, int n, Position pos) {
        int ny = pos.y + 1;
        int nx = pos.x;

        return checkRange(n, ny, nx) && map[ny][nx] == 0;
    }

    private static boolean checkRange(int n, int y, int x) {
        return 0 <= y && y <= n && 0 <= x && x <= n;
    }
}