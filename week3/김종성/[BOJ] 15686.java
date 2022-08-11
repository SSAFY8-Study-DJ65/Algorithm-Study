import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * G5
 * 15686 - 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */
public class Main {

    static class Position {
        int y, x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Chicken {
        Position pos;

        public Chicken(int y, int x) {
            this.pos = new Position(y, x);
        }
    }

    static class Home {
        Position pos;

        public Home(int y, int x) {
            this.pos = new Position(y, x);
        }
    }

    private static List<Chicken> chickens = new ArrayList<>();
    private static List<Home> homes = new ArrayList<>();
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Home(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Chicken(i, j));
                }
            }
        }
        System.out.println(getMinChickenDist(new int[m], 0, 0));
    }

    private static int getMinChickenDist(int[] sel, int idx, int k) {
        if (k == m) {
            int cityChickenDist = 0;
            for (Home home : homes) {
                int chickenDist = Integer.MAX_VALUE;
                for (int i : sel) {
                    chickenDist = Math.min(chickenDist, getDist(home.pos, chickens.get(i).pos));
                }
                cityChickenDist += chickenDist;
            }

            return cityChickenDist;
        }
        if (idx == chickens.size()) return Integer.MAX_VALUE;

        int ret = Integer.MAX_VALUE;
        sel[k] = idx;
        ret = Math.min(ret, getMinChickenDist(sel, idx + 1, k + 1));
        return Math.min(ret, getMinChickenDist(sel, idx + 1, k));
    }

    private static int getDist(Position p1, Position p2) {
        return Math.abs(p1.y - p2.y) + Math.abs(p1.x - p2.x);
    }
}