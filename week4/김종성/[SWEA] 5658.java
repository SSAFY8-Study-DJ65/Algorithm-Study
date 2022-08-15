import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 모의 SW 역량테스트
 * 5658 - 보물상자 비밀번호
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo&
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int unit = n / 4;

            LinkedList<Character> q = new LinkedList<>();
            for (char ch : br.readLine().toCharArray()) {
                q.add(ch);
            }

            PriorityQueue<Integer> password = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < unit; i++) {
                for (int j = 0; j < n; j += unit) {
                    String hex = "";
                    for (int h = j; h < j + unit; h++) {
                        hex += q.get(h);
                    }
                    int pwd = Integer.parseInt(hex, 16);

                    if (!password.contains(pwd)) {
                        password.add(pwd);
                    }
                }
                q.offer(q.poll());
            }

            while (k-- > 1) {
                password.poll();
            }

            System.out.printf("#%d %d\n", tc, password.poll());
        }
    }
}