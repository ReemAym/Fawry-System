package Services;
import java.util.ArrayList;
import Discounts.Discount;

public class MobileRechargeServices extends Services 
{
	public MobileRechargeServices() 
	{
		serviceName = "Mobile Recharge Services";
	}
	
	// decorator method implementation
	public double cost()
	{
		return 15;
	}
}
