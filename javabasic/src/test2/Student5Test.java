package test2;

public class Student5Test {

	public static void main(String[] args) {
		Student5 studentlee = new Student5();
		studentlee.setStudentName("이지원");
		System.out.println(studentlee.serialNum);
		studentlee.serialNum++;
		
		Student5 studentson = new Student5();
		studentson.setStudentName("손수경");
		System.out.println(studentson.serialNum);
		System.out.println(studentlee.serialNum);
		

	}

}
