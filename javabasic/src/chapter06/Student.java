package chapter06;

public class Student {
	public static int serialNum =1000;
	public int studentID;
	public String address;
	public String studentName;
	public int grade;
	public int money;
	
	
	//이름과 가진돈을 매개변수로 받는 생성자
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
		this.studentID = serialNum++;
	}
	 
	
	public void takeOnBus(Bus bus) {
		bus.takeOn(1000);
		this.money -=1000;
	}
	
	public void takeOffBus(Bus bus) {
		bus.takeOff();
		
	}
	
	public void takeOnsubway(Subway subway) {
		subway.takeOn(1500);
		this.money -=1500;
	}
	
	public void takeOffsubway(Subway subway) {
		subway.takeOff();
		
	}
	
	public void showInfo() {
		System.out.println(studentID);
	}
	
	public static void showSerial() {
		System.out.println(serialNum);
	}
	
	
}
