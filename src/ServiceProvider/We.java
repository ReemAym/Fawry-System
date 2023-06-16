package ServiceProvider;
import java.util.ArrayList;

import Services.Donations;
import Services.InternetPaymentServices;
import Services.LandlineServices;
import Services.MobileRechargeServices;
import Services.Services;

public class We extends ServiceProvider
{	
	public We() 
	{
		service = new ArrayList<Services>();
	}
	// factory method implementations
	public void createService (String serviceName)
	{
		if (serviceName.equals("Mobile Recharge Services"))
		{
			service.add(new MobileRechargeServices());
		}
		else if (serviceName.equals("Internet Payment Services"))
		{
			service.add(new InternetPaymentServices());
		}
	}
}
