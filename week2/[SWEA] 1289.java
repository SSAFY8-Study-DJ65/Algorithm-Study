import java.util.Scanner;
import java.io.FileInputStream;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int T= sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
            String memory=sc.next();
            int cnt=0; //바꾼 횟수
            int[] arr=new int[memory.length()];
            for(int i=0;i<arr.length;i++) {
                arr[i]=0; //값 초기화
            }
             
            for(int i=0;i<memory.length();i++) {
                if(memory.charAt(i)=='1' && arr[i]==0) {
                    for(int j=i;j<arr.length;j++) {
                        arr[j]=1;
                    }
                    cnt++;
                }
                else if(memory.charAt(i)=='0' && arr[i]==1) {
                    for(int j=i;j<arr.length;j++) {
                        arr[j]=0;
                    }
                    cnt++;
                }
            }
            //System.out.println(Arrays.toString(arr));
            System.out.println("#"+tc+" "+cnt);
        }
    }
}
