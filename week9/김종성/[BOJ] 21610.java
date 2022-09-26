import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * G5
 * 21610 - 마법사 상어와 비바라기
 * https://www.acmicpc.net/problem/21610
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

    private static int n, m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Pos> clouds = new ArrayList<>();
        int[][] initDir = {{0, 0}, {0, 1}, {-1, 0}, {-1, 1}};
        int y = n - 1;
        int x = 0;
        for (int[] d : initDir) {
            clouds.add(new Pos(y + d[0], x + d[1]));
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            ans = move(clouds, d - 1, s);
        }
        System.out.println(ans);
    }

    private static int move(List<Pos> clouds, int d, int s) {
        boolean[][] v = new boolean[n][n];
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        for (Pos cloud : clouds) {
            // 구름 d방향으로 s만큼 이동
            for (int i = 0; i < s; i++) {
                cloud.y = (cloud.y + dir[d][0] + n) % n;
                cloud.x = (cloud.x + dir[d][1] + n) % n;
            }

            v[cloud.y][cloud.x] = true;
            map[cloud.y][cloud.x]++;
        }

        // 구름이 있는 곳의 바구니를 기준으로 인접한 대각선의 물이 담긴 바구니 갯수 카운트
        int[] temp = new int[clouds.size()];
        for (int i = 0; i < temp.length; i++) {
            Pos cloud = clouds.get(i);

            int cnt = 0;
            for (int k = 1; k < 8; k += 2) {
                int ny = cloud.y + dir[k][0];
                int nx = cloud.x + dir[k][1];

                if (checkRange(ny, nx) && map[ny][nx] > 0) {
                    cnt++;
                }
            }
            temp[i] = cnt;
        }

        // 대각선에 물이 담긴 바구니 수만큼 물 증가
        for (int i = 0; i < temp.length; i++) {
            Pos cloud = clouds.get(i);
            map[cloud.y][cloud.x] += temp[i];
        }

        // 모든 구름 제거
        clouds.clear();

        // 바구니의 물의 양이 2이상인 경우 구름 생성 후 물의 양 2감소
        int water = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !v[i][j]) {
                    clouds.add(new Pos(i, j));
                    map[i][j] -= 2;
                }
                water += map[i][j];
            }
        }
        return water;
    }

    private static boolean checkRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}