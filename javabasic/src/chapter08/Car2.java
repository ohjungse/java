package chapter08;

public class Car2 {
	String color;
	int speed;
	
	public void upspeed(int speed)
	{
		this.speed += speed;
	}
	
	
	public void showInfo() 
	{
		System.out.println(this.color + "," + this.speed);
	}
}
