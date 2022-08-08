import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * D3
 * 9229 - 한빈이와 Spot Mart
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(weight);

            int front = 0, back = n - 1;
            int max = 0;
            while (front < back) {
                int sum = weight[front] + weight[back];
                if (sum > m) {
                    back--;
                } else if (sum < m) {
                    max = Math.max(max, sum);
                    front++;
                } else {
                    max = sum;
                    break;
                }
            }

            System.out.printf("#%d %d\n", tc, max == 0 ? -1 : max);
        }
    }
}