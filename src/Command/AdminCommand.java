package Command;

import Main.AdminMenu;
import Main.InitialData;


public class AdminCommand implements Command
{
	InitialData data;
	// receiver
	AdminMenu adminMenu;
	public AdminCommand(InitialData data) 
	{
		this.data=data;
		adminMenu = new AdminMenu (data);
	}
	// command pattern method implementation
	public void execute()
	{
		adminMenu.showAdminMenu();
	}
	
}
