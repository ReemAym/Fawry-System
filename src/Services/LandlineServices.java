package Services;

import java.util.ArrayList;

import Receipt.Receipt;

public class LandlineServices extends Services 
{	
	public LandlineServices()
	{
		serviceName = "Landline Services";
	}
	
	// decorator method implementation
	public double cost()
	{
		return 5;
	}
}
