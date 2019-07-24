package Test;

public class Student1 {
	int studentid;
	String studentname;
	int grade;
	String address;
	
	
	public String getstudentname() 
	{
		return studentname;
	}
	
	
	public void setstudentname(String name)
	{
		studentname = name;
	}
	
	public static void main(String[] args) 
	{
	Student1 studentoh = new Student1();
	studentoh.studentname = "오중세";
	
	System.out.println(studentoh.studentname);
	System.out.println(studentoh.getstudentname());
	}
	
	
	
	
}

	

	
