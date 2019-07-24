package Test;

public class Man {
		public int age = 40;
		public String name ="james";
		boolean married = true;
		int child = 3;
			
	
	public static void Man(int age, String name,int child)
	{
		age = age;
		name = name;
		child = child;
		
	}
	public void married() {
		married = true;
	}
	
	
	public void ManInfo(){
		System.out.println(name+"의 나이는 "+age + "이고,"
				+ "결혼한것은 " + married +
				"이며, 자식은" +child + " 명입니다.");
	}
	
	
	
}
