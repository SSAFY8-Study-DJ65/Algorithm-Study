import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s41158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++)
			q.add(i);
		
		 String str = "<";
		 
		 while(q.size() > 1) {
			 for(int i = 0; i < K-1; i++) {
				 int value = q.poll();
				 q.offer(value);
			 }
			 str = str + q.poll() + ", ";
		 }
		 str = str+q.poll()+">";
		 System.out.println(str);
	}
}
