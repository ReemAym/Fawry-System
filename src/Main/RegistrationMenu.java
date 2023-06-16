package Main;
import java.util.Scanner;
import User.User;

//menu for user registration 

public class RegistrationMenu
{
	Scanner input = new Scanner(System.in);
	InitialData data;
	
	public RegistrationMenu(InitialData data) 
	{
		this.data = data;
	}
	
	
	public void chooseRegistration()
	{
		boolean result = false;
		
		System.out.println("--------------------------------------------------");
		System.out.println("1) SignUp");
		System.out.println("2) SignIn");
		System.out.println("0) Exit");
		
		System.out.print("Enter number:");
		data.regNum = input.nextInt();
		System.out.println();
		
		while (data.regNum!=0)
		{
			String username;
			String email;
			String pass;
			
			if (data.regNum==1) // option 1 sign up  
			{
				User user = new User(data.registration);
				
				System.out.print("Enter UserName:");
				username = input.next();
				System.out.print("Enter Email:");
				email = input.next();
				System.out.print("Enter Password:");
				pass = input.next();
				
				result = user.signup(username,pass,email);
				
				if (result) {
					System.out.println("\nSuccessfull SignUp\n");
				}
				else {
					System.out.println("\nUnSuccessfull SignUp\n");
				}
			}
			
			else if (data.regNum==2) // option 2 sign in
			{
				User user = new User(data.registration);
				System.out.print("Enter Email:");
				email = input.next();
				System.out.print("Enter Password:");
				pass = input.next();
				
				result = user.signIn(email, pass);
				
				if (result) {
					System.out.println("\nSuccessfull SignIn\n");
					data.user = data.registration.selectedUser;
					data.user.wallet.money=100;
					data.user.card.creditCardMoney=5000;
					break;
				}
				else {
					System.out.println("\nUnSuccessfull SignIn\n");
				}
				
			}
			
			System.out.println("--------------------------------------------------");
			System.out.println("1) SignUp");
			System.out.println("2) SignIn");
			System.out.println("0) Exit");
			System.out.print("Enter num:");
			data.regNum = input.nextInt();
			System.out.println();
		}
		
	}
	
	
}
