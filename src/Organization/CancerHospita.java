package Organization;

import Services.Donations;

public class CancerHospita extends Organization
{
	// factory method implementations
	public void createService (String serviceName)
	{
		if (serviceName.equals("Donations"))
		{
			service = new Donations();
		}
	}
}
