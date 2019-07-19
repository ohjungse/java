/*
 * 1. 필요로 하는 변수 선언
 * 2. 작업번호가 4가 아닌 동안 반복
 *   2.1 선택 메뉴 디스플레이
 *   2.2 작업 종류 입력
 *   2.3 작업 종류에 따라
 *     2.3.1 입금의 경우 :
 *     		  입금액을 입력받는다.
 *     		  입금앨을 잔고에 누계한다.
 *     2.3.2 출금의 경우 :
 *     		  출금액을 입력받는다.
 *     		  출금액이 잔고보다 작으면 잔고에서 
 */
















package chapter04;

import java.util.Scanner;

public class EX3 {

	public static void main(String[] args) {
		//1.필요한 변수 선언
		int jobNumber=0, balance=0, workMoney=0;
		Scanner sc= new Scanner(System.in);
		
		//2. 작업번호가 4가 아닌동안 무한반복
		do {
			//2.1 선택메뉴 디스플레이
			System.out.println("1.입금 2.출금 3.잔고조회 4.종료");
			//2.2 작업종류 입력
			System.out.println("선택>>");
			jobNumber =sc.nextInt();
			//2.3작업종류에 따라
			switch(jobNumber) 
			{
			case 1://입금의 경우
				System.out.println("입금액>>");
				workMoney=sc.nextInt();
				balance+=workMoney; //balance = balance + workMoney
				System.out.println("입금 되었습니다.");
				break;
			case 2://출금의 경우
				System.out.println("출금액>>");
				workMoney=sc.nextInt();
				if(workMoney <= balance)
				balance-=workMoney; //balance = balance - workMoney
				
				else System.out.println("잔고가 부족합니다.");
				break;
			case 3://잔고 조회의 경우
				System.out.println("현재 잔고 >>" + balance);
				break;
			case 4:
				break;
			default :
				System.out.println("선택을 다시해 주세요.");
			}//end of switch
		
			
			
		}while(jobNumber !=4);
		
			//3. 프로그램 종료	
			System.out.println("프로그램을 종료합니다.");

	}//end of name

}//end of class
