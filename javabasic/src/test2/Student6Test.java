package test2;

public class Student6Test {

	public static void main(String[] args) {
		Student6 studentlee = new Student6();
		studentlee.setStudentName("이지원");
		System.out.println(studentlee.serialNum);
		System.out.println(studentlee.studentName + "학번"
				+studentlee.studentID);
		
		Student6 studentson = new Student6();
		studentson.setStudentName("손수경");
		System.out.println(studentson.serialNum);
		System.out.println(studentson.studentName +
				studentson.studentID);
		
		

	}

}
