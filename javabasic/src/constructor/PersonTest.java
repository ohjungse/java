package constructor;

public class PersonTest {

	public static void main(String[] args) {
		
		
		Person personkim = new Person();
		personkim.name = "김유신";
		personkim.weight = 85.5F;
		personkim.height = 180.0F;
		
		Person personLee = new Person("이순신", 175, 75);
		
		

	}

}
