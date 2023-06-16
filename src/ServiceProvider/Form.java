package ServiceProvider;

import java.util.ArrayList;

import User.User;

// form for each service providers

public class Form 
{
	public ArrayList <String> fields;
	
	public Form() 
	{
		fields = new ArrayList<String>();
	}
	
	// add field to form
	public void addField (String f)
	{
		fields.add(f);
	}
	
	public ArrayList <String> getFields ()
	{
		return fields;
	}
	
}
