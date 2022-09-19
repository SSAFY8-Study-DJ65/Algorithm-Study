import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BOJ 3184 S1 양
 */
public class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;

	static int sheep, wolf;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'o')
					sheep++;
				else if (map[i][j] == 'v')
					wolf++;
			}
		}

		// #울타리 o양 v늑대
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
				// 양이 늑대한테 싸움을 거니까 양 기준으로
				if (map[i][j] == 'o') {

					ArrayList[] result = bfs(i, j);

					ArrayList<Point> sheeps = result[0];
					ArrayList<Point> wolves = result[1];

					if (sheeps.size() > wolves.size()) {
						wolf -= wolves.size();
						for (Point w : wolves) {
							map[w.x][w.y] = '.';
						}
					}
					// 양 먹는다
					else if (sheeps.size() <= wolves.size()) {
						sheep -= sheeps.size();
						for (Point s : sheeps) {
							map[s.x][s.y] = '.';
						}
					}
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	public static ArrayList[] bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();

		ArrayList[] result = new ArrayList[2];
		result[0] = new ArrayList<Point>();
		result[1] = new ArrayList<Point>();

		visited[x][y] = true;
		queue.offer(new Point(x, y));
		result[0].add(new Point(x, y));

		while (!queue.isEmpty()) {

			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C)
					continue;
				if (visited[nx][ny])
					continue;
				if (map[nx][ny] == '#')
					continue;

				visited[nx][ny] = true;
				queue.offer(new Point(nx, ny));

				if (map[nx][ny] == 'o') { // 양
					result[0].add(new Point(nx, ny));
				} else if (map[nx][ny] == 'v') { // 늑대
					result[1].add(new Point(nx, ny));
				}
			}
		}
		return result;
	}

}
