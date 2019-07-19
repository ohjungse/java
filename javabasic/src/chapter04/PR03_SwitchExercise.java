/*
 * 프로그램 작성 전, 처리과정 표현방법
 * 1. 순서도
 * 2. 의사코드(Pseudo code) : 일상의 언어를 빌려 처리 과정을 순서대로 기술하는 것.
 */




package chapter04;

import java.util.Scanner;

public class PR03_SwitchExercise {

	public static void main(String[] args) {
		// 1. 필요한 변수를 선언한다. 생년, 나이
//		int birthyear, age;
//		Scanner sc = new Scanner(System.in);
//		
		// 2. 생년을 입력하라는 메세지를 출력하고 입력받는다.
//		System.out.println("생년은? ");
//		birthyear = sc.nextInt();
//		
//		// 3. 나이를 계산한다.
//		age = 2019-birthyear;
//		
//		// 4. 계산된 나이를 10으로 나누어 몫이
//		switch(age/10){
//		//    4.1) 0, 1의 경우에는 미성년이라 출력한다.
//	    case 0: case 1:
//	    	System.out.println("미성년 입니다.");
//	    	break;
//		//    4.2) 2인 경우에는 청년이라 출력한다.
//	    case 2: case 3:
//	    	System.out.println("청년 입니다.");
//	    	break;
//		//    4.3) 3, 4, 5인 경우에는 중장년이라 출력한다.
//	    case 4: case 5:
//	    	System.out.println("중장년 입니다.");
//	    	break;
//		//    4.4) 6이상인 경우에는 노년이라 출력한다.
//	    default :
//	    	System.out.println("노년 입니다.");
//		}//end of switch
		
		
//		int birthyear, age;
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("생년을 입력하세요 :");
//		birthyear = sc.nextInt();
//		
//		age = 2019-birthyear;
//		
//		switch(age/10) {
//		case 1:
//			System.out.println("미성년");
//			break;
//		ca
//		}
		
		int num;
		Scanner sc= new Scanner(System.in);
		System.out.println("사용하고자 하는 항목을 선택하시오. :");
		num =  sc.nextInt();
		String num2;
		
		while(num<4)
		{
			
		switch(num)
		{
		case 1: num2 = "입금";
		
		        break;
		case 2: num2 = "출금";
		 		break;
		case 3: num2 = "잔고";
				break;
				
		default:
			    num2 = "종료";
			    break;
			    
		}
		System.out.println("사용 항목  :"+ num2);
		
	
		}
		}

}
