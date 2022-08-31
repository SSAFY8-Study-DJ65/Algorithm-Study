import java.util.*;
import java.io.*;
 
class Solution
{
    static int[] di = { 1, 1, -1, -1 };
    static int[] dj = { 1, -1, -1, 1 };
    static boolean [][] v;
    static int [][] arr;
    static int N, ans;
    static HashSet<Integer> set;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
         
        for(int tc = 1; tc <= T; tc++) {
             
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            N = Integer.parseInt(str);
 
            arr = new int[N][N];
            ans = -1;
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i = 0; i < N-2; i++) {
                for(int j = 1; j <= N-2; j++) {
                    v = new boolean[N][N];
                    set = new HashSet<>();
                     
                    set.add(arr[i][j]);
                    v[i][j] = true;
                    dfs(i, j, i, j, 0);
                    v[i][j] = false;
                    set.remove(arr[i][j]);
                }
            }
            sb.append("#").append(tc).append(" ").append(ans);
            System.out.println(sb);
        }
    }
     
        public static void dfs(int i, int j, int si, int sj, int side) {
            for(int d = side; d < 4; d++) {
                int ni = i + di[d];
            int nj = j + dj[d];
             
            if(ni == si && nj == sj && set.size() >= 4) {
                int cnt = set.size();
                ans = Math.max(ans, cnt);
                return;
            }
                if(0 > ni || 0 > nj || ni >= N || nj >= N || v[ni][nj]) continue;
            if(set.contains(arr[ni][nj])) continue;
             
            v[ni][nj] = true;
            set.add(arr[ni][nj]);
//          중요!! 현재 방향에서 회전해야 하므로 d 주기!!
            dfs(ni, nj, si, sj, d);
            set.remove(arr[ni][nj]);
            v[ni][nj] = false;
            }
             
        }
}
