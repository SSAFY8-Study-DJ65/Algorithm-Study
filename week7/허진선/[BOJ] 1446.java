package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1446 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		shortcut = new ArrayList();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (to > d) {
				continue;
			}
			shortcut.add(new Path(from, to, w));
		}
		Collections.sort(shortcut);
//		for (Path p : shortcut) {
//			System.out.println(p.from + " " + p.to);
//		}
		res = Integer.MAX_VALUE;
		go(0, 0, 0);
		System.out.println(res);
	}

	static int n, d, res;
	static ArrayList<Path> shortcut;

	private static class Path implements Comparable<Path>{
		int from;
		int to;
		int w;

		public Path(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Path o) { // 시작 번호가 작은 순으로 정렬
			return Integer.compare(this.from, o.from);
		}
	}

	private static void go(int idx, int jumpTo, int dist) {
        if (idx == n-1) {
            res = Math.min(res, dist + d - jumpTo);
            return;
        }

        Path path = shortcut.get(idx);
        if (jumpTo <= path.from) { 
            go(idx + 1, path.to, dist + path.w + path.from - jumpTo); // 지름길을 사용했을 때
        }
        go(idx + 1, jumpTo, dist); // 지름길을 사용하지 않았을 때
    }

}
