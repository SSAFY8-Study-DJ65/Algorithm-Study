import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			String line = sc.next();
			
			char[] arr = line.toCharArray();
			
			int len = arr.length;
			
			Stack<Character> stack = new Stack<>();
			
			int sum = 0;
			
			for(int i=0; i<len; i++) {
				
				if(arr[i] == '(') {
					stack.push('(');
				}
				else if(arr[i-1] == '(' && arr[i] == ')') {
					stack.pop();
					sum += stack.size();
				}
				else if(arr[i] == ')' && arr[i-1] == ')') {
					stack.pop();
					sum += 1;
				}
				
			}
			
			System.out.println("#" + t + " " + sum);
		}

	}

}
