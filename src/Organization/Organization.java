package Organization;

import ServiceProvider.Form;
import Services.Services;

// Organization where the donations go 

public abstract class Organization 
{
	public Form form;
	public Services service;
	
	// factory method
	public abstract void createService (String serviceName);
	
	// form for organizations
	public void addForm (Form f) 
	{
		form = f;
	}
	
	public Form getForm() 
	{
		return form;
	}
	
	// service for organizations
	public Services getService ()
	{
		return service;
	}
}
