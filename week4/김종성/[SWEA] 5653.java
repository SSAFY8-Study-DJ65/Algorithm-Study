import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 모의 SW 역량테스트
 * 5653 - 줄기세포배양
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo&
 */
public class Solution {

    private static final int PADDING = 300;
    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static class Cell implements Comparable<Cell> {
        int y;
        int x;
        int hp;
        int timeToActivate;
        boolean active;
        int timeToDie;

        public Cell(int y, int x, int hp, int timeToActivate) {
            this.y = y;
            this.x = x;
            this.hp = hp;
            this.timeToActivate = timeToActivate;
            this.active = false;
            this.timeToDie = timeToActivate + hp;
        }

        public void activate() {
            this.active = true;
        }

        @Override
        public int compareTo(Cell o) {
            if (active) {
                return timeToDie - o.timeToDie;
            } else {
                if (timeToActivate == o.timeToActivate) {
                    return o.hp - hp;
                }
                return timeToActivate - o.timeToActivate;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[700][700];

            PriorityQueue<Cell> disabled = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int hp = Integer.parseInt(st.nextToken());
                    map[PADDING + i][PADDING + j] = hp;

                    if (hp > 0) {
                        disabled.offer(new Cell(PADDING + i, PADDING + j, hp, hp));
                    }
                }
            }

            PriorityQueue<Cell> active = new PriorityQueue<>();
            int time = 0;
            while (time < k) {
                while (!disabled.isEmpty() && disabled.peek().timeToActivate == time) {
                    Cell cell = disabled.poll();
                    cell.activate();
                    active.offer(cell);

                    for (int[] d : dir) {
                        int ny = cell.y + d[0];
                        int nx = cell.x + d[1];

                        if (map[ny][nx] == 0) {
                            map[ny][nx] = cell.hp;
                            disabled.offer(new Cell(ny, nx, cell.hp, time + cell.hp + 1));
                        }
                    }
                }

                time++;

                while (!active.isEmpty() && active.peek().timeToDie == time) {
                    active.poll();
                }
            }

            System.out.printf("#%d %d\n", tc, disabled.size() + active.size());
        }
    }
}