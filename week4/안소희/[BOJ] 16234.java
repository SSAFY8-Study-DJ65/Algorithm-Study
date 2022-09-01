import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	 static int N;
	 static int L;
	 static int R;
	 static int[][] map;
	 static final int[] dx = {0, 0, -1, 1};
	 static final int[] dy = {1, -1, 0, 0};
     static boolean[][] visited;

	 public static void main(String[] args) throws IOException {

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer str = new StringTokenizer(br.readLine(), " ");

	        N = Integer.parseInt(str.nextToken());
	        L = Integer.parseInt(str.nextToken());
	        R = Integer.parseInt(str.nextToken());
	        map = new int[N][N];
	        visited = new boolean[N][N];

	        for (int i = 0; i < N; i++) {
	            str = new StringTokenizer(br.readLine(), " ");
	            for (int j = 0; j < N; j++) {
	                map[i][j] = Integer.parseInt(str.nextToken());
	            }
	        }
	        int result = 0; 
	        boolean flag = true; 

	        while (flag) {
	            if (movePeople() == 0) 
	                flag = false;
	            else
	                result++;
	        }

	        System.out.println(result);
	    }

	    static int movePeople() {
	        int unionCount = 0;
	        
	        for (int r = 0; r < N; r++) {
	            for (int c = 0; c < N; c++) {
	                if (!visited[r][c]) {
	                    Queue<Pair> queue = new LinkedList<>();
	                    Pair location = new Pair(r, c);
	                    queue.add(location);

	                    List<Pair> list = new ArrayList<>();
	                    list.add(location);

	                    visited[location.r][location.c] = true;

	                    int unionSum = map[location.r][location.c];

	                    while (!queue.isEmpty()) {
	                        Pair current = queue.poll();

	                        for (int i = 0; i < 4; i++) {
	                            int nr = current.r + dx[i];
	                            int nc = current.c + dy[i];

	                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
	                                if (!visited[nr][nc] && checkBoundary(current.r, current.c, nr, nc)) {
	                                    queue.add(new Pair(nr, nc));
	                                    list.add(new Pair(nr, nc));
	                                    visited[nr][nc] = true;
	                                    unionCount++;
	                                    unionSum += map[nr][nc];
	                                }
	                            }
	                        }
	                    }

	                    //인구분배
	                    if (unionCount > 0) {
	                        int aver = unionSum / list.size();

	                        for (int i = 0; i < list.size(); i++) {
	                            Pair current = list.get(i);
	                            map[current.r][current.c] = aver;
	                        }
	                    }
	                }
	            }
	        }

	        // 초기화
	        for (int i = 0; i < N; i++) {
	            Arrays.fill(visited[i], false);
	        }

	        return unionCount;
	    }
	    
	    static boolean checkBoundary(int cr, int cc, int nr, int nc) {
	        int sub = Math.abs(map[cr][cc] - map[nr][nc]);

	        if (sub >= L && sub <= R)
	            return true;

	        return false;
	    }

	    static class Pair {
	        int r;
	        int c;

	        public Pair(int r, int c) {
	            this.r = r;
	            this.c = c;
	        }
	    }


}
