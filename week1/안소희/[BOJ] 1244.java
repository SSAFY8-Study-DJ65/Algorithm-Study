package com.ssafy.day02.boj;

import java.util.Scanner;

public class boj1244 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt()+1;
		//스위치 상태를 담을 배열
		int[] arr=new int[n];
		//0번째 인덱스는 쓰지않음
		for(int i=1;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		//학생 수
		int student=sc.nextInt();
		
		for(int i=0;i<student;i++) {
			
			int gender=sc.nextInt();
			int cnt=sc.nextInt();
			
			if(gender==1) {
				//남학생인 경우
				for(int j=cnt;j<n;j+=cnt) {
					arr[j]=Math.abs(arr[j]-1);
				}
			}
			else if(gender==2){
				//여학생인 경우
				int lf=cnt-1;
				int rt=cnt+1;
				while(true) {
					if(lf<1||rt>=n) break;
					if(arr[lf]!=arr[rt]) break;
					lf--;
					rt++;
				}
				lf++;
				rt--;
				for(int j=lf;j<=rt;j++) {
					arr[j]=Math.abs(arr[j]-1);
				}
			}
		}
		
		for(int i=1;i<n;i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0)
				System.out.println();
		}
	}
}
