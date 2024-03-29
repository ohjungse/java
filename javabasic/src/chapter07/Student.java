package chapter07;

import java.util.ArrayList;

public class Student {
		int studentID;
		String studentName;
		ArrayList<Subject> subjectList; //***
		
		public Student(int studentID, String studentName) {
			this.studentID = studentID;
			this.studentName = studentName;
			subjectList = new ArrayList<Subject>(); //***
		}// end of constructor Student
		
		public void addSubject(String name, int score) {
			Subject subject = new Subject();
			subject.setName(name);
			subject.setScorePoint(score);
			subjectList.add(subject);
		}
		
		public void showStudentInfo() 
		{
			int total = 0;
			for(Subject s : subjectList) 
			{
				total += s.getScorePoint();
				System.out.println("학생 "+studentName+"의 "+s.getName()+"과목성적은 "
									+s.getScorePoint()+"입니다." );
			}// for
			System.out.println("학생"+studentName+"의"+"총점은"+total+"입니다.");
		}
}//end of class Student
