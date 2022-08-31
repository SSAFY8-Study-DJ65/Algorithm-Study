import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Point {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}public class Main {
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] di = { -1, 0, 1, 0 };
	public static int[] dj = { 0, -1, 0, 1 };
	public static int N, L, R;
	public static int answer = 0;
	private static boolean temp;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		while (true) {
			boolean isBfs = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j))
							isBfs = true;
					}
				}
			}
			if (!isBfs) {
				break;
			} else {
				answer++;
			}
		}
		System.out.println(answer);
	}
	public static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean bfs(int x, int y) {
		boolean isUnion = false;
		ArrayList<Point> unionList = new ArrayList<>();
		unionList.add(new Point(x, y));
		int count = 1;
		int sum = map[x][y];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int curX = queue.peek().x;
			int curY = queue.poll().y;
			for (int i = 0; i < 4; i++) {
				int nx = curX + di[i];
				int ny = curY + dj[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
					int val = Math.abs(map[curX][curY] - map[nx][ny]);
					if (val >= L && val <= R && !visited[nx][ny]) {
						unionList.add(new Point(nx, ny));
						count++;
						sum += map[nx][ny];
						visited[nx][ny] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
		if (unionList.size() > 1) {
			isUnion = true;
			int result = sum / count;
			for (int i = 0; i < unionList.size(); i++) {
				Point p = unionList.get(i);
				map[p.x][p.y] = result;
			}
		}
		return isUnion;
	}
}
