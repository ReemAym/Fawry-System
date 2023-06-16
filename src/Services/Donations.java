package Services;
import java.util.ArrayList;

import Organization.Organization;

public class Donations extends Services 
{
	public Donations() 
	{
		serviceName = "Donations";
	}
	
	// decorator method implementation
	public double cost()
	{
		return 10;
	}
}
