package chapter08;

public class VIPCustomer extends Customer{
	int agentID;
	 double saleRatio;
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		this.customerGrade = "VIP";
		this.bonusRatio = 0.05;
		this.saleRatio = 0.1;
		this.agentID = agentID;
		System.out.println("VIPCustomer(int, String) 생성자 호출 ");
	}
	
	public int getAgentID() 
	{
		return agentID;
	}
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;		
		return price-(int)(price*saleRatio);
	}
	public void VIPshowInfo(int customerID, String customerName,int agentID) 
	{
		
	}
}
