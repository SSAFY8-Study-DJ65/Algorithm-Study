import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int h = 0; h < R; h++) {
			int tn = N;
			int tm = M;
			for (int i = 0; i < Math.min(N, M) / 2; i++) {
				int ttemp[] = new int[(tn*2)+((tm-2)*2)];	
				int idx = 0;

				// 잘라 넣기
				// 우
				for (int j = i; j < M - 1 - i; j++)
					ttemp[idx++] = arr[i][j];
				// 하
				for (int j = i; j < N - 1 - i; j++)
					ttemp[idx++] = arr[j][M - 1 - i];
				// 좌
				for (int j = M - 1 - i; j > i; j--)
					ttemp[idx++] = arr[N - 1 - i][j];
				// 상
				for (int j = N - 1 - i; j > i; j--)
					ttemp[idx++] = arr[j][i];

				// 돌리기
				int tmp = ttemp[0];
				int tempb[] = new int[ttemp.length];
				System.arraycopy(ttemp, 1, tempb, 0, ttemp.length-1);
				tempb[ttemp.length-1] = tmp;
				
				// 다시 넣기
				idx = 0;
				for (int j = i; j < M - 1 - i; j++)
					arr[i][j] = tempb[idx++];
				for (int j = i; j < N - 1 - i; j++)
					arr[j][M - 1 - i] = tempb[idx++];
				for (int j = M - 1 - i; j > i; j--)
					arr[N - 1 - i][j] = tempb[idx++];
				for (int j = N - 1 - i; j > i; j--)
					arr[j][i] = tempb[idx++];
				
				tn = tn - 2;
				tm = tm - 2;
			}

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
