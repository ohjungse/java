/*
 * 사용자가 단을 입력하면 해당 단의 구구단을 출력하는 프로그램을 작성하시오.
 * 단, 0을 입력하면 프로그램을 종료하시오.
 */




package chapter04;

import java.util.Scanner;

public class EX4 {

	public static void main(String[] args) {
//		//내가 만든것
//		Scanner sc= new Scanner(System.in);
//		int num,dan, j=1 ;
//		System.out.println("단을 입력하시오. :");
//		num = sc.nextInt();
//		
//		for(dan=1; dan<=num ; dan++) 
//		{
//			dan=num;
//		    for(j=1; j<=9; j++)
//			
//		    System.out.println("x*y ="+dan*j);
//		}
//		
		//필요 변수 선언
		int dan=1;
		Scanner sc =new Scanner(System.in);
		
		while(dan !=0) 
		{
			System.out.println("몇 단??>> ");
			dan = sc.nextInt();
			if(dan==0)break;
			
			for(int times=1; times<=9; times++)
			   {
				System.out.println(dan+"*"+times+"="+(dan*times));
			   }//end of for
		}//end of while
		System.out.println("프로그램 종료");
	}

}
