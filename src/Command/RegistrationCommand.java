package Command;

import Main.InitialData;
import Main.RegistrationMenu;

public class RegistrationCommand implements Command
{
	InitialData data;
	// receiver
	RegistrationMenu registrationMenu;
	
	public RegistrationCommand(InitialData data) 
	{
		this.data=data;
		registrationMenu = new RegistrationMenu (data);
	}
	// command pattern method implementation
	public void execute()
	{
		registrationMenu.chooseRegistration();
	}
}
