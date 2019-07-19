/*
 * 방정식 4x + 5y = 60의 모든 해를 구하는 프로그램을 작성하시오.
 * 단 x, y는 10 이하의 자연수로 한정한다.
 * 1. x가 1부터 10보다 작거나 같은 동안 반복
 *   1.1 y가 1부터 10 보다 작거나 같은 동안 반복
 *     1.1.1 4x + 5y == 60이면 x, y를 출력
 * 2. 프로그램 종료
 */

package chapter04;

import java.util.Scanner;

public class EX5 {

	public static void main(String[] args) {

		
		//다중 for roof사용 한 방정식 풀이 예제
		
		for(int x =1; x<=10; x++)
		{
			for(int y=1; y<=10; y++)
			{
				if((4*x +5*y)==60)
					System.out.println("해 x,y :" + x +","+y);
			}//inner for(y
		}// outer for(x
		

	}

}
