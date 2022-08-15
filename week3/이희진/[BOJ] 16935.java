import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class s116935 {

    public static void main(String[] args) throws IOException {

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
        
        int temp[][] = new int[1][1];

        st = new StringTokenizer(br.readLine());
        for (int tc = 0; tc < R; tc++) {
            int S = Integer.parseInt(st.nextToken());
            int x;
            int y;

            switch (S) {
            case 1:
                temp = new int[N][M];
                x = 0;
                y = 0;
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    y = 0;
                    x++;
                }
                break;

            case 2:
                temp = new int[N][M];
                x = 0;
                y = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = M - 1; j >= 0; j--) {
                        temp[x][y++] = arr[i][j];
                    }
                    y = 0;
                    x++;
                }
                break;

            case 3:
                temp = new int[M][N];
                x = 0;
                y = 0;
                for (int i = 0; i < M; i++) {
                    for (int j = N - 1; j >= 0; j--) {
                        temp[x][y++] = arr[j][i];
                    }
                    y = 0;
                    x++;
                }
                break;

            case 4:
                temp = new int[M][N];
                x = 0;
                y = 0;
                for (int i = M - 1; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {
                        temp[x][y++] = arr[j][i];
                    }
                    y = 0;
                    x++;
                }
                break;
                
            case 5:
                temp = new int[N][M];
                x = 0;
                y = 0;

                // ↑
                for (int i = N / 2; i < N; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = 0;
                }

                // →
                y = M / 2;
                x = 0;

                for (int i = 0; i < N / 2; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = M / 2;
                }

                // ↓
                y = 0;
                for (int i = N / 2; i < N; i++) {
                    for (int j = M / 2; j < M; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = 0;
                }

                // ←
                x = N / 2;
                y = M / 2;
                for (int i = 0; i < N / 2; i++) {
                    for (int j = M / 2; j < M; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = M / 2;
                }
                break;

            case 6:
                temp = new int[N][M];
                x = 0;
                y = 0;

                // ←
                for (int i = 0; i < N / 2; i++) {
                    for (int j = M / 2; j < M; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = 0;
                }

                // ↑
                x = 0;
                y = M / 2;
                for (int i = N / 2; i < N; i++) {
                    for (int j = M / 2; j < M; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = M / 2;
                }

                // ↓
                y = 0;
                for (int i = 0; i < N / 2; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = 0;
                }

                // →
                x = N / 2;
                y = M / 2;
                for (int i = N / 2; i < N; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        temp[x][y++] = arr[i][j];
                    }
                    x++;
                    y = M / 2;
                }
                break;
            }
            N = temp.length;
            M = temp[0].length;
            arr = new int[temp.length][temp[0].length];
            for(int i = 0; i < temp.length; i++)
            	System.arraycopy(temp[i], 0, arr[i], 0, temp[0].length);
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
