import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc= new Scanner(System.in);
		
		for(int tc=1;tc<=10;tc++) {
			int n=Integer.parseInt(br.readLine());
			ArrayList<Integer> num = new ArrayList<>();
			StringTokenizer str=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				num.add(Integer.parseInt(str.nextToken()));
			}
			
			//System.out.println(Arrays.toString(num));
			int command= Integer.parseInt(br.readLine());
			str= new StringTokenizer(br.readLine());
			for(int i=0;i<command;i++) {
				
				String com = str.nextToken();
				int x=Integer.parseInt(str.nextToken());
				int y=Integer.parseInt(str.nextToken());
				
				for (int j = 0; j < y; j++) {
					num.add(x,Integer.parseInt(str.nextToken()));
					x++;
				}
			}
			StringBuilder sb=new StringBuilder();
			
			sb.append("#"+tc+" ");
			if(num.size()<10) {
				for(int i=0;i<num.size();i++) {
					sb.append(num.get(i)+" ");
				}
			}
			else {
				
				for(int i=0;i<10;i++) {
					sb.append(num.get(i)+" ");
				}
			}
			System.out.println(sb);
		}
		
	}

}
