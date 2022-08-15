import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
/**
 * D3
 * 1220 - Magnetic
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD
 */
public class Solution {
 
    private static final int TABLE_SIZE = 100;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] table = new int[TABLE_SIZE][TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++) {
                table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
 
            int count = 0;
            for (int i = 0; i < TABLE_SIZE; i++) {
                int temp = 0;
                for (int j = 0; j < TABLE_SIZE; j++) {
                    if (table[j][i] == 1) temp = 1;
                    else if (table[j][i] == 2) {
                        count += temp;
                        temp = 0;
                    }
                }
            }
 
            System.out.printf("#%d %d\n", tc, count);
        }
    }
}