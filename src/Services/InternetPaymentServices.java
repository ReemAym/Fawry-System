package Services;
import java.util.ArrayList;
import Discounts.Discount;

public class InternetPaymentServices extends Services 
{	
	public InternetPaymentServices() 
	{
		serviceName = "Internet Payment Services";
	}
	
	// decorator method implementation
	public double cost()
	{
		return 20;
	}
}
