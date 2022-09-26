import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * G3
 * 16954 - 움직이는 미로 탈출
 * https://www.acmicpc.net/problem/16954
 */
public class Main {

    private static final int SIZE = 8;
    private static final char EMPTY = '.';
    private static final char WALL = '#';

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[SIZE][SIZE];

        PriorityQueue<Pos> wallQ = new PriorityQueue<>((o1, o2) -> o2.y - o1.y);

        for (int i = 0; i < SIZE; i++) {
            String input = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == WALL) {
                    wallQ.add(new Pos(i, j));
                }
            }
        }

        System.out.println(bfs(board, wallQ));
    }

    private static int bfs(char[][] board, PriorityQueue<Pos> wallQ) {
        int[][] dir = {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        Queue<Pos> ugje = new ArrayDeque<>();
        ugje.add(new Pos(SIZE - 1, 0));

        while (!ugje.isEmpty()) {
            int qSize = ugje.size();

            for (int i = 0; i < qSize; i++) {
                Pos cur = ugje.poll();

                if (board[cur.y][cur.x] == WALL)
                    continue;

                for (int[] d : dir) {
                    int ny = cur.y + d[0];
                    int nx = cur.x + d[1];

                    if (checkRange(ny, nx) && board[ny][nx] == EMPTY) {
                        if (ny == 0 && nx == SIZE - 1) {
                            return 1;
                        }

                        ugje.add(new Pos(ny, nx));
                    }
                }
            }

            moveWall(board, wallQ);
        }

        return 0;
    }

    private static boolean checkRange(int y, int x) {
        return 0 <= y && y < SIZE && 0 <= x && x < SIZE;
    }

    private static void moveWall(char[][] board, PriorityQueue<Pos> wallQ) {
        List<Pos> temp = new ArrayList<>();
        while (!wallQ.isEmpty()) {
            Pos wall = wallQ.poll();
            int ny = wall.y + 1;
            int nx = wall.x;

            board[wall.y][wall.x] = EMPTY;
            if (ny < SIZE) {
                board[ny][nx] = WALL;
                temp.add(new Pos(ny, nx));
            }
        }

        wallQ.addAll(temp);
    }
}