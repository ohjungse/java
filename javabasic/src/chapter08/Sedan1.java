package chapter08;

public class Sedan1 extends Car1 {
	// field
	// color, speed 는 Car1에서 상속된 것...
	
	
	public void setSpeed(int speed) 
	{
//		this.speed = speed;
	}
	
	public void setcolor(String color) 
	{
		super.setcolor(color);
	}
}
