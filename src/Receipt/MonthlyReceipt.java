package Receipt;

import Services.LandlineServices;

public class MonthlyReceipt extends Receipt
{
	// factory method implementations
	public void createService (String serviceName)
	{
		if (serviceName.equals("Landline Services"))
		{
			service = new LandlineServices();
		}
	}
	
}
