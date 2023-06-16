package Payment;

import Services.Services;

// User Transactions

public class Transaction 
{
	// transaction service
	public Services ser;
	// transaction money
	public double money;
	
	public void setService(Services s)
	{
		ser = s;
	}
	
	public void setMoney(double m)
	{
		money = m;
	}
}
