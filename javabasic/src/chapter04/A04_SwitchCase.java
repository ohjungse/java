package chapter04;

import java.util.Scanner;

public class A04_SwitchCase {

	public static void main(String[] args) {
//		int number1 = 2;
//		
//		switch(number1) {
//		case 1:
//			System.out.println("숫자 1");
//			break;
//		case 2:
//			System.out.println("숫자 2");
//			break;
//		case 3:
//			System.out.println("숫자 3");
//			break;
//		}

//		if(number1==1) {
//			System.out.println("숫자 1");
//		}
//		else if(number1==2) {
//			System.out.println("숫자 2");
//		}
//		else if(number1==3) {
//			System.out.println("숫자 3");
//		}
//		else {
//			System.out.println("나머지 숫자");
//		}

//		int number1 = 6;
//		int remainder;
//		
//		remainder = number1 % 2;
//		
//		switch(remainder) {
//		case 0 :
//		    System.out.println("짝수");
//		break;
//		case 1 :
//			System.out.println("홀수");
//		break;
//		default :
//			break;
//		}
		
//		int num1;
//		int a, b, c;
//		a=7;
//		b=4;
//		c=5;
//		
//		switch(a%3) {
//		case 0 :
//			System.out.println("3의 배수");
//			break;
//		case 1 :
//			System.out.println("4의 배수");
//			break;
//		case 2 :
//			System.out.println("5의 배수");
//			break;
//		}
		
		
//		Scanner sc = new  
//				
//		
//		int num1;
//		
//		if(num1%3==0) {
//			System.out.println("3의 배수");
//		}
//		else if((num1%4)==0) {
//			System.out.println("4의 배수");
//		}
//		else if((num1%5)==0){
//			System.out.println("5의 배수");
//		}
//		else {
//			System.out.println("나머지");
//		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		int number = sc.nextInt();
		
		if((number%6)==0) {
			System.out.println("6의 배수 입니다.");
		}else if((number%7)==0) {
			System.out.println("7의 배수 입니다.");
		}else if((number%9)==0) {
			System.out.println(("9의 배수 입니다."));
		}else {
			System.out.println("6, 7, 9의 배수가 아닙니다.");
		}
		
		
				
		
		
	}

}
