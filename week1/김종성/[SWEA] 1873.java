import java.util.Scanner;

/**
 * D3
 * 1873 - 상호의 배틀필드
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc#none
 */
public class Solution {

    private static final char FLAT = '.';
    private static final char STONE_WALL = '*';
    private static final char STEEL_WALL = '#';
    private static final char WATER = '-';
    private static final char UP = '^';
    private static final char DOWN = 'v';
    private static final char LEFT = '<';
    private static final char RIGHT = '>';

    private static char[][] map;
    private static int h, w;
    private static Tank tank;

    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Tank {
        private char dir;
        Position pos;

        public Tank(char dir, Position pos) {
            this.dir = dir;
            this.pos = pos;
        }

        public void order(char o) {
            switch (o) {
                case 'U':
                    move(UP);
                    break;
                case 'D':
                    move(DOWN);
                    break;
                case 'R':
                    move(RIGHT);
                    break;
                case 'L':
                    move(LEFT);
                    break;
                default:
                    shoot();
            }
        }

        private void shoot() {
            int[] d = direction[getDirIdx(this.dir)];
            int ny = pos.y + d[0];
            int nx = pos.x + d[1];

            while (true) {
                if (!checkRange(ny, nx) || map[ny][nx] == STEEL_WALL)
                    break;

                if (map[ny][nx] == STONE_WALL) {
                    map[ny][nx] = FLAT;
                    break;
                }

                ny += d[0];
                nx += d[1];
            }
        }

        private int getDirIdx(int d) {
            switch (d) {
                case UP:
                    return 0;
                case RIGHT:
                    return 1;
                case DOWN:
                    return 2;
                default:
                    return 3;
            }
        }

        private void move(char d) {
            this.dir = d;
            int y = pos.y + direction[getDirIdx(d)][0];
            int x = pos.x + direction[getDirIdx(d)][1];
            if (checkRange(y, x) && map[y][x] == FLAT) {
                map[pos.y][pos.x] = FLAT;
                map[y][x] = d;
                pos.y = y;
                pos.x = x;
            } else {
                map[pos.y][pos.x] = d;
            }
        }

        private boolean checkRange(int y, int x) {
            if (0 <= y && y < h && 0 <= x && x < w)
                return true;
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            h = sc.nextInt();
            w = sc.nextInt();

            map = new char[h][w];

            for (int i = 0; i < h; i++) {
                char[] chars = sc.next().toCharArray();
                for (int j = 0; j < w; j++) {
                    char ch = chars[j];
                    map[i][j] = ch;
                    if (ch == UP || ch == DOWN || ch == LEFT || ch == RIGHT) {
                        tank = new Tank(ch, new Position(i, j));
                    }
                }
            }

            int cmdCnt = sc.nextInt();
            String order = sc.next();
            for (char o : order.toCharArray()) {
                tank.order(o);
            }

            print(tc);
        }
    }

    private static void print(int tc) {
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(tc).append(" ");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}