package Search;

import java.util.ArrayList;

import Services.Services;

// Search for Service

public class Search 
{
	// list of service in system
	ArrayList<Services> servicesList;
	
	public Search (ArrayList<Services> servicesList)
	{
		this.servicesList = servicesList;
	}
	
	// function return all services that match the user query 
	public ArrayList<Services> serach (String name)
	{
		ArrayList<Services> servicesMatch = new ArrayList<Services>();
		
		name = name.toLowerCase();
		
		for (int i=0;i<servicesList.size();i++)
		{
			String n = servicesList.get(i).getServiceName().toLowerCase();
			
			if(n.indexOf(name)!=-1)
			{
				servicesMatch.add(servicesList.get(i));
			}
		}
		
		return servicesMatch;
	}
}


