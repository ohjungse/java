package chapter06;

public class Subway {
	String lineNumber;
	int passengerCount;
	int money;
	
	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public void takeOn(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void takeOff() {
		this.passengerCount--;
	}
	
	public void showInfo() {
		System.out.println(lineNumber + "호선 지하철 손님은" 
	                       +passengerCount + "명이고, 수입은" + money + "원입니다.");
	}
}
