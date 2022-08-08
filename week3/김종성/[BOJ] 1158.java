import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * S4
 * 1158 - 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        int idx = 0;
        List<Integer> result = new ArrayList<>();
        while (!arr.isEmpty()) {
            idx = (idx + k - 1) % arr.size();
            result.add(arr.get(idx));
            arr.remove(idx);
        }

        StringBuilder sb = new StringBuilder("<").append(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            sb.append(", ").append(result.get(i));
        }
        sb.append(">");
        System.out.println(sb);
    }
}