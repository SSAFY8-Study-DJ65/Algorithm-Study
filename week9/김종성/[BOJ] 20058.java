import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * G4
 * 20058 - 마법사 상어와 파이어스톰
 * https://www.acmicpc.net/problem/20058
 */
public class Main {

    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int gridSize;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        gridSize = (int) Math.pow(2, n);
        grid = new int[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            firestorm(Integer.parseInt(st.nextToken()));
        }

        boolean[][] v = new boolean[gridSize][gridSize];
        int totalIce = 0;
        int iceMass = 0;

        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                totalIce += grid[y][x];
                if (grid[y][x] != 0 && !v[y][x]) {
                    iceMass = Math.max(iceMass, bfs(v, y, x));
                }
            }
        }

        System.out.println(totalIce);
        System.out.println(iceMass);
    }

    private static void firestorm(int L) {
        int size = (int) Math.pow(2, L);
        grid = rotateAll(size);

        List<Pos> melt = new ArrayList<>();
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                if (grid[y][x] == 0)
                    continue;

                int cnt = 0;
                for (int[] d : dir) {
                    int ny = y + d[0];
                    int nx = x + d[1];

                    if (checkRange(ny, nx) && grid[ny][nx] > 0) {
                        cnt++;
                    }
                }

                if (cnt < 3) {
                    melt.add(new Pos(y, x));
                }
            }
        }

        for (Pos m : melt) {
            grid[m.y][m.x]--;
        }
    }

    private static int[][] rotateAll(int size) {
        int[][] temp = new int[gridSize][gridSize];
        for (int y = 0; y < gridSize; y += size) {
            for (int x = 0; x < gridSize; x += size) {
                rotate(temp, y, x, size);
            }
        }
        return temp;
    }

    private static void rotate(int[][] temp, int r, int c, int size) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                temp[r + x][c + size - y - 1] = grid[r + y][c + x];
            }
        }
    }

    private static boolean checkRange(int y, int x) {
        return 0 <= y && y < gridSize && 0 <= x && x < gridSize;
    }

    private static int bfs(boolean[][] v, int y, int x) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(y, x));
        v[y][x] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            cnt++;

            for (int[] d : dir) {
                int ny = cur.y + d[0];
                int nx = cur.x + d[1];

                if (checkRange(ny, nx) && !v[ny][nx] && grid[ny][nx] != 0) {
                    v[ny][nx] = true;
                    queue.add(new Pos(ny, nx));
                }
            }
        }

        return cnt;
    }
}