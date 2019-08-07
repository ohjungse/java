package chapter07;

public class TwoDimension {

	public static void main(String[] args) {
		// 2차원 배열 선언
//		int[][] arr = new int [2][3];
		int[][] arr = {{1,2,3}, {4,5,6}};
		
		for(int i = 0; i < arr.length; i ++) 
		{
			for(int j = 0; j < arr[i].length; j++) 
			{
			System.out.printf("%3d",arr[i][j]);	
			}//inner loop by j
			System.out.println();
		}//outer loop by i
		System.out.println("2차원배열의 개념 확인!!");
	}

}
