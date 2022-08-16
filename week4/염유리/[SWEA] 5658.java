import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			String line = sc.next();
			
			ArrayList<Character> list = new ArrayList<>();
			int rot = N/4;
			for(int i=0; i<N; i++) {
				list.add(line.charAt(i));
			}
			
			ArrayList<String> anslist = new ArrayList<>();
			
			while(rot-- >= 0) {
				for(int i=0; i<=N-N/4; i+=N/4) {
					String temp = "";
					for(int j=i; j<i+N/4; j++) {
						temp += list.get(j);
					}
					if(!anslist.contains(temp)) {
						anslist.add(temp);
					}
				}
				char item = list.remove(N-1);
				list.add(0, item);
			}
			Collections.sort(anslist, Collections.reverseOrder());
			System.out.println("#" + t + " "  + Integer.parseInt(anslist.get(K-1), 16));
		}

	}

}
