import java.util.Scanner;

/**
 * S5
 * 17478 - 재귀함수가 뭔가요?
 * https://www.acmicpc.net/problem/17478
 */
public class Main {

    private static final String underBar = "____";
    private static final String question = "\"재귀함수가 뭔가요?\"\n";
    private static final String middle1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    private static final String middle2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    private static final String middle3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    private static final String footer = "라고 답변하였지.\n";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        StringBuilder sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        sb = rec(cnt, 0, sb);

        System.out.println(sb);
    }

    private static StringBuilder rec(int cnt, int recCnt, StringBuilder response) {
        String header = underBar.repeat(recCnt);
        response.append(header).append(question);

        if (cnt == recCnt) {
            response.append(header).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            response.append(header).append(middle1);
            response.append(header).append(middle2);
            response.append(header).append(middle3);
            response = rec(cnt, recCnt+1, response);
        }

        response.append(header).append(footer);
        return response;
    }
}