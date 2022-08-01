import java.io.IOException;
import java.util.Scanner;

public class d346152 {

    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=tc;i++) {
            n = sc.nextInt();
            int m = sc.nextInt();
            arr = new int[n][n];
            // 가운대 고정 W B B W
            arr[n/2][n/2] = 2;
            arr[n/2][n/2-1] = 1;
            arr[n/2-1][n/2] = 1;
            arr[n/2-1][n/2-1] = 2;
 
            for(int j=0;j<m;j++) {
                int x = sc.nextInt()-1;
                int y = sc.nextInt()-1;
                int c = sc.nextInt(); // 1 흑, 2 백
                arr[y][x] = c;
                // 가로 바꾸기
                garo(c,y,x);
                // 세로 바꾸기
                sero(c,y,x);
                // 대각선 바꾸기
                degac(c,y,x);
            }
            int b = 0;
            int w = 0;
            for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++) {
                    if(arr[j][k]==1) b++;
                    else if(arr[j][k]==2) w++;
                }
            }
            System.out.println("#"+i+" "+b+" "+w);
        }
    }
    
    private static void garo(int c,int x,int y) {
        boolean flag = false;
        // 오른쪽 살피기
        for(int i=y+1;i<n;i++) {
            if(arr[x][i]==0) break;
            if(arr[x][i]==c) {
                flag = true;
                break;
            }
        }
        // 바꾸기
        if(flag) {
            for(int i=y+1;i<n;i++) {
                if(arr[x][i]==c||arr[x][i]==0) break;
                arr[x][i] = c;
            }
        }
        flag = false;
        // 왼쪽 살피기
        for(int i=y-1;i>=0;i--) {
            if(arr[x][i]==0) break;
            if(arr[x][i]==c) {
                flag = true;
                break;
            }
        }
        // 바꾸기
        if(flag) {
            for(int i=y-1;i>=0;i--) {
                if(arr[x][i]==c||arr[x][i]==0) break;
                arr[x][i] = c;
            }
        }
    }
    
    private static void sero(int c,int x,int y) {
        boolean flag = false;
        // 아래로 살피기
        for(int i=x+2;i<n;i++) {
            if(arr[i][y]==0) break;
            if(arr[i][y]==c) {
                flag = true;
                break;
            }
        }
        // 바꾸기
        if(flag) {
            for(int i=x+1;i<n;i++) {
                if(arr[i][y]==c||arr[i][y]==0) break;
                arr[i][y] = c;
            }
        }
        flag = false;
        // 위로 살피기
        for(int i=x-2;i>=0;i--) {
            if(arr[i][y]==0) break;
            if(arr[i][y]==c) {
                flag = true;
                break;
            }
        }
        // 바꾸기
        if(flag) {
            for(int i=x-1;i>=0;i--) {
                if(arr[i][y]==c||arr[i][y]==0) break;
                arr[i][y] = c;
            }
        }
    }
    
    private static void degac(int c,int x,int y) {
        boolean flag = false;
        // 오른쪽 아래 점검
        for(int i=x+2,j=y+2;i<n&&j<n;i++,j++) {
            if(arr[i][j]==0) break;
            if(arr[i][j]==c) {  
                flag = true;
                break;
            }
        }
        if(flag) {
            for(int i=x+1,j=y+1;i<n&&j<n;i++,j++) {
                if(arr[i][j]==c||arr[i][j]==0) break;
                arr[i][j] = c;
            }
        }
        flag = false;
        // 오른쪽 위 점검
        for(int i=x-2,j=y+2;i>=0&&j<n;i--,j++) {
            if(arr[i][j]==0) break;
            if(arr[i][j]==c) {  
                flag = true;
                break;
            }
        }
        if(flag) {
            for(int i=x-1,j=y+1;i>=0&&j<n;i--,j++) {
                if(arr[i][j]==c||arr[i][j]==0) break;
                arr[i][j] = c;
            }
        }
        flag = false;
        // 왼쪽 아래 점검
        for(int i=x+2,j=y-2;i<n&&j>=0;i++,j--) {
            if(arr[i][j]==0) break;
            if(arr[i][j]==c) {  
                flag = true;
                break;
            }
        }
        if(flag) {
            for(int i=x+1,j=y-1;i<n&&j>=0;i++,j--) {
                if(arr[i][j]==c||arr[i][j]==0) break;
                arr[i][j] = c;
            }
        }
        flag = false;
        // 왼쪽 위 점검
        for(int i=x-2,j=y-2;i>=0&&j>=0;i--,j--) {
            if(arr[i][j]==0) break;
            if(arr[i][j]==c) {  
                flag = true;
                break;
            }
        }
        if(flag) {
            for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--) {
                if(arr[i][j]==c||arr[i][j]==0) break;
                arr[i][j] = c;
            }
            return;
        }
        flag = false;
    }
}

