package Main;
import java.util.Scanner;

//menu for admin functions 

public class AdminMenu
{
	Scanner input = new Scanner(System.in);
	InitialData data;
	public AdminMenu(InitialData data) 
	{
		this.data = data;
	}
	// function to show choices for admin 
	public void showAdminMenu() 
	{
		System.out.println("1) List all Refund Requst");
		System.out.println("0) Exit");
		System.out.print("Enter Number:");
		int num = input.nextInt();
		System.out.println();
		
		while(num!=0)
		{
			if (num==1) // option list all refund requests 
			{
				for (int i=0;i<data.admin.refundRequests.size();i++)
				{
					System.out.println("Unique Name = "+ data.admin.refundRequests.get(i).unique);
					System.out.println("Service Name = "+ data.admin.refundRequests.get(i).service.getServiceName());
					System.out.println("Amount = "+ data.admin.refundRequests.get(i).amount);
					System.out.println("---------------------------------------------------------");
				}
				// if there are refund requests in list
				if (data.admin.refundRequests.size()!=0) 
				{
					System.out.print("Enter Request Unique Name you want to accept or reject:");
					String name = input.next();
					System.out.print("Enter y for accept, n for reject:");
					String flag = input.next();
					
					if (flag.equals("y")) 
					{
						data.admin.replyRequest(name, true);
						System.out.println("Successfull Transaction");
					}
					else if (flag.equals("n")) 
					{
						data.admin.replyRequest(name, false);
					}
				}
				
				// if no refund request in list
				else {
					System.out.println("No Refund Requests");
				}
			}
			
			System.out.println("\n--------------------------------------------------");
			System.out.println("1) List all Refund Requst");
			System.out.println("0) Exit");
			System.out.print("Enter Number:");
			num = input.nextInt();
			System.out.println();
		}
	}
	
}
