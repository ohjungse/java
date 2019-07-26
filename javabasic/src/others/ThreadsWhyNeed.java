package others;

public class ThreadsWhyNeed {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			sum+=i;
		}
		System.out.println("합계 : " + sum);
		long end = System.currentTimeMillis();
		System.out.println("연산시간 : " + (end-start) + "ms");
	}

}
