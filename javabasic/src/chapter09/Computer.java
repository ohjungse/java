


package chapter09;

public abstract class Computer {
	public abstract void display(); // body 없는 메서드
	public abstract void typing(); // body 없는 메서드
	public void turnOn() { //body 있는 메서드
		System.out.println("전원을 켭니다.");
	}
}
