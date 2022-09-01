import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class swea보물상자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer str= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(str.nextToken());
			int k=Integer.parseInt(str.nextToken());
			
			ArrayList<Character> arr=new ArrayList<>();
			HashSet<Long> num=new HashSet<>();
			String st=br.readLine();
			String tmp="";
			for(int i=0;i<n;i++) {
				arr.add(st.charAt(i));
				if(tmp.length()==n/4) {
					num.add(Long.parseLong(tmp,16));
					tmp=""+st.charAt(i);
				}else {
					tmp+=st.charAt(i);
				}
			}
			num.add(Long.parseLong(tmp,16));
			tmp="";
			//초기값 설정
			
			//회전
			for(int rot=0;rot<n/4-1;rot++) {
				char temp=arr.get(n-1);
				arr.remove(n-1); //맨 뒤에 있는 거를 앞으로 가져옴
				arr.add(0, temp);
				
				//System.out.println(arr);
				for(int i=0;i<n;i++) {
					
					if(tmp.length()==n/4) {
						num.add(Long.parseLong(tmp,16));
						tmp=""+arr.get(i);
					}else {
						tmp+=arr.get(i);
					}
				}
				num.add(Long.parseLong(tmp,16));
				tmp="";
			}
			
			ArrayList<Long> res=new ArrayList<>(num);
			Collections.sort(res,Collections.reverseOrder());
			//System.out.println(res.size());
			//System.out.println(res);
			sb.append(res.get(k-1)).append("\n");
		}
		System.out.println(sb);
	}

}
