package Main;
import java.util.Scanner;

import Command.Command;
import Command.RegistrationCommand;
import Command.AdminCommand;
import Command.UserCommand;


public class Main {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		InitialData Data = new InitialData();
		
		System.out.println("1) User");
		System.out.println("2) Admin");
		System.out.println("0) Exit");
		System.out.println("Enter Num");
		int option = input.nextInt();
		
		while (option!=0)
		{
			if (option==1) 
			{
				Command command = new RegistrationCommand(Data);
				command.execute();
				
				if (Data.regNum!=0) 
				{	
					Command command1 = new UserCommand(Data);
					command1.execute();
				}

			}
			if (option == 2) 
			{
				Command command2 = new AdminCommand(Data);
				command2.execute();
			}
			
			System.out.println("1) User");
			System.out.println("2) Admin");
			System.out.println("0) Exit");
			System.out.println("Enter Num");
			option = input.nextInt();
		}
		
		
	}

}
