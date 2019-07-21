package Test;

public class StudentTest1 {

	public static void main(String[] args) {
		Student1 studentoh = new Student1();
		studentoh.studentname = "오방떡";
		
		Student1 studentkim = new Student1();
		studentkim.studentname = "김랄라";
		
		
		System.out.println(studentoh.studentname);
		System.out.println(studentoh.getstudentname());
		
		System.out.println(studentkim.studentname);
		System.out.println(studentkim.getstudentname());
		
		System.out.println(studentoh);
		System.out.println(studentkim);

	}

}
