package Command;

import Main.InitialData;
import Main.UserMenu;

public class UserCommand implements Command
{
	InitialData data;
	// receiver
	UserMenu userMenu;
	public UserCommand(InitialData data) 
	{
		this.data=data;
		userMenu = new UserMenu (data);
	}
	// command pattern method implementation
	public void execute()
	{
		userMenu.chooseFromMenu();
	}
}
