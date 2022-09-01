import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(br.readLine());
		
		int h=Integer.parseInt(str.nextToken());
		int w=Integer.parseInt(str.nextToken());
		int [] rain = new int[w];
		
		str=new StringTokenizer(br.readLine());
		
		for(int i=0;i<w;i++) {
			rain[i]=Integer.parseInt(str.nextToken());
		}
		int res=0;
		for(int i=1;i<w;i++) {
			int lt=0,rt=0;
			for(int j=0;j<i;j++) {
				//왼쪽 벽 설정
				lt=Math.max(lt, rain[j]);
			}
			for(int j=i+1;j<w;j++) {
				//오른쪽 벽 설정
				rt=Math.max(rt, rain[j]);
			}
			
			if(rain[i]<lt && rain[i]<rt) res+=Math.min(rt, lt)-rain[i];
			
		}
		
		System.out.println(res);
	}

}
