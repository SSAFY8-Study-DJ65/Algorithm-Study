import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * G4
 * 2665 - 미로만들기
 * https://www.acmicpc.net/problem/2665
 */
public class Main {

    private static final int WHITE = 1;
    private static final int BLACK = 0;

    private static class Cell implements Comparable<Cell> {
        int y;
        int x;
        int changeCnt;

        public Cell(int y, int x, int changeCnt) {
            this.y = y;
            this.x = x;
            this.changeCnt = changeCnt;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(changeCnt, o.changeCnt);
        }
    }

    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Cell start = new Cell(0, 0, 0);

        dist[0][0] = 0;
        pq.add(start);

        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int cnt = 0;
        while (!pq.isEmpty()) {
            Cell now = pq.poll();

            if (now.y == n - 1 && now.x == n - 1) {
                cnt = now.changeCnt;
                break;
            }

            if (now.changeCnt > dist[now.y][now.x])
                continue;

            for (int[] d : dir) {
                int ny = now.y + d[0];
                int nx = now.x + d[1];

                if (checkRange(ny, nx)) {
                    if (map[ny][nx] == WHITE && now.changeCnt < dist[ny][nx]) {
                        dist[ny][nx] = now.changeCnt;
                        pq.add(new Cell(ny, nx, now.changeCnt));
                    }

                    if (map[ny][nx] == BLACK && now.changeCnt + 1 < dist[ny][nx]) {
                        dist[ny][nx] = now.changeCnt + 1;
                        pq.add(new Cell(ny, nx, now.changeCnt + 1));
                    }
                }
            }
        }

        return cnt;
    }

    private static boolean checkRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}