package chapter04;

import java.util.Scanner;

public class A05_Whilestmt {

	public static void main(String[] args) {
		// 1부터 5까지의 수를 출력하는 프로그램을 작성하시오.
//		int num =1;
//		System.out.println(num);
//		num++;
//		System.out.println(num);
//		num++;
//		System.out.println(num);
//		num++;
//		System.out.println(num);
//		num++;
//		System.out.println(num);
		
		// 위 프로그램을 반복문을 사용하여 작성하면....
//		int num=1;
//		
//		while(num<=1000000) {
//			System.out.println(num);
//			num++;
//			
//		}
		//변수 선언
//		int num=1, oddsum=0, evensum=0;
//		while(num<=100) {
//			if((num % 2) ==0)oddsum =oddsum+num;
//			else evensum += num;
//			
//			num++;
//		
//		}//end of while
//		System.out.println("odd Sum :" + oddsum);
//		System.out.println("even sum: " + evensum);
		
//		int startnum, finishnum, num;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("시작숫자를 입력하세요. :");
//		startnum = sc.nextInt();
//		System.out.println("끝나는 숫자를 입력하세요. :");
//		finishnum = sc.nextInt();
//		num = startnum;
//		num = 1;
//		
//		while(startnum<=finishnum) {
//			System.out.println("시작숫자부터 끝나는 숫자의 합계는 :" +num);
//			num++;
//		}
		
		int snum, fnum, num, sum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("시작하는 숫자 :");
		snum = sc.nextInt();
		System.out.println("끝나는 숫자");
		fnum = sc.nextInt();
		
		num=1;
		sum=0;
		while(snum<=fnum)
		{
			System.out.println(snum);
			sum=sum+snum;
			
			snum+=num;
		}
		System.out.println(sum);
	   
		
	}

}
