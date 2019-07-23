package test2;

public class Student6 {
		public static int serialNum=1000;
		public int studentID;
		public String studentName;
		public int grade;
		public String address;
		
		
	public Student6() {
		serialNum++;
		studentID = serialNum;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String name) {
		studentName = name;
	}
	public static int getserialNum() {
		int i = 10;
		return serialNum;
	}
	public static void setserialNum(int serialNum) {
		Student6.serialNum = serialNum;
	}
}
