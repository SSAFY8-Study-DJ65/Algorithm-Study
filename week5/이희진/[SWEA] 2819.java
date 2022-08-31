import java.util.*;
import java.io.*;
 
class Solution {
    static int ans;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static HashSet<String> set;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        int [][] map = new int[4][4];
         
        for(int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
             
            set = new HashSet<>();
            ans = 0;
             
            for(int i = 0; i < 4; i++) {             
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    dfs(i, j, map, "");
                }
            }
            sb.append("#").append(tc).append(" ").append(ans);
            System.out.println(sb);
         
        }
    }
     
    static void dfs(int i, int j, int[][] map, String str) {
        if(str.length() >= 7) {
            if(set.add(str)) {
                ans++;
            }
//          System.out.println(str);
            return;
        }
         
        str = str+map[i][j];
         
        for(int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(0 <= ni && ni < 4 && 0 <= nj && nj < 4) {
                dfs(ni, nj, map, str);
            }
        }
    }
}
