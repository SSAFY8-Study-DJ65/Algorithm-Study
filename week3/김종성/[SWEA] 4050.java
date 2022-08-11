import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * D4
 * 4050 - 재관이의 대량 할인
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIseXoKEUcDFAWN
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int totalPrice = 0;
            int cnt = 0;
            while (!pq.isEmpty()) {
                cnt++;
                Integer price = pq.poll();
                if (cnt == 3) cnt = 0;
                else totalPrice += price;
            }

            System.out.printf("#%d %d\n", tc, totalPrice);
        }
    }
}