package Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Admin.Admin;
import Discounts.OverallDiscount;
import Discounts.SpecificDiscount;
import Payment.AddingFunds;
import Payment.CacheOnDelivery;
import Payment.Payment;
import Payment.RefundRequest;
import Payment.Transaction;
import Search.Search;
import ServiceProvider.ServiceProvider;
import Services.Services;
import User.User;

// menu for user functions 

public class UserMenu
{
	Scanner input = new Scanner(System.in);
	InitialData data;
	
	public UserMenu (InitialData data) 
	{
		this.data = data;
	}
	
	// function to show choices for admin 
	public int menu() 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("User Mnue:");
		System.out.println("1) View Services and Choose");
		System.out.println("2) Search for Service");
		System.out.println("3) Adding Funds");
		System.out.println("4) Show Discounts");
		System.out.println("5) Ask for Refund Request");
		System.out.println("0) Exit");
		System.out.print("Enter number:");
		int number = input.nextInt();
		System.out.println();
		
		return number;
	}
	
	public void chooseFromMenu() // choose option
	{
		int num = menu();
		
		while (num!=0)
		{
			//choose service, service provider and pay 
			if (num==1) 
			{
				int serviceNum = chooseServices();
				Services choosenService = chooseServiceProvider(serviceNum);
				displayFormAndPayMenu(choosenService);
			}
			//search
			else if (num==2) 
			{
				searchforService();
			}
			
			//add funds from credit card to wallet 
			else if (num==3) 
			{
				addingFunds();
			}
			
			//show available Discounts
			else if (num==4)
			{
				showDiscounts();
			}
			
			//ask for refundRequst
			else if (num==5)
			{
				askForRefund();
			}
			
			num = menu();
		}
	}
	
	//option 1-----------------------------------------------------------------------------------------------
	//choose which service
	public int chooseServices() 
	{
		System.out.println("********************************");
		System.out.println("Services:");
		for (int i=0;i<data.services.size();i++)  // loop print service on system data
		{
			System.out.println(i+1+") "+data.services.get(i).getServiceName());
		}
		 System.out.print("Enter service number:");
		int serviceNum = input.nextInt();
		System.out.println();
		
		return serviceNum;
	}
	
	//choose which service provider
	public Services chooseServiceProvider(int serviceNum) 
	{
		ArrayList<ServiceProvider> sp = new ArrayList<ServiceProvider>();
		Services choosenService = data.services.get(serviceNum-1);
			
		if (choosenService.getServiceName().equals("Internet Payment Services") ||
				choosenService.getServiceName().equals("Mobile Recharge Services")) 
		{
			for (int i=0;i<data.e.getService().size();i++)  // loop check if Etisalat support this service
			 {
				// check if Etisalat has service whose name equal to choosen service name
				if (data.e.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
				{
					sp.add(data.e);
				}
			 }
			 
			 for (int i=0;i<data.o.getService().size();i++) // loop check if Orange support this service
			 {
				// check if Orange has service whose name equal to choosen service name
				if (data.o.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
				{
					sp.add(data.o);
				}
			 }
			 
			 for (int i=0;i<data.w.getService().size();i++)  // loop check if We support this service
			 {
				// check if We has service whose name equal to choosen service name
				if (data.w.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
				{
					sp.add(data.w);
				}
			 }
			 
			 for (int i=0;i<data.v.getService().size();i++)  // loop check if Vodafone support this service
			 {
				// check if Vodafone has service whose name equal to choosen service name
				if (data.v.getService().get(i).getServiceName().equals(data.services.get(serviceNum-1).getServiceName())) 
				{
					sp.add(data.v);
				}
			 }
			 
			 //choose which service provider user wants
			 System.out.println("********************************");
			 System.out.println("The provider for this service:");
			 for (int i=0; i<sp.size();i++)
			 {
				 if (sp.get(i)==data.e) 
				 {
					 System.out.println("Enter e for Etisalat");
				}
				 else if (sp.get(i)==data.o) 
				 {
					 System.out.println("Enter o for Orange");
				}
				 else if (sp.get(i)==data.w) 
				 {
					 System.out.println("Enter w for We");
				}
				 else if (sp.get(i)==data.v) 
				 {
					 System.out.println("Enter v for Vodafone");
				}
			 }
		}
		
		else if (choosenService.getServiceName().equals("Landline Services"))
		{
			System.out.println("********************************");
			System.out.println("The receipt for this service:");
			System.out.println("Enter m for Monthly Receipt");
			System.out.println("Enter q for Quarter Receipt");
		}
		
		else if (choosenService.getServiceName().equals("Donations"))
		{
			System.out.println("********************************");
			System.out.println("The organization for this service:");
			System.out.println("Enter s for School");
			System.out.println("Enter c for Cancer Hospital");
			System.out.println("Enter n for NGOs");
		}
		
		 
		 return choosenService;
	}
	
	//display service provider form
	public void displayFormAndPayMenu(Services choosenService)
	{
		 System.out.print("\nEnter Which Provider:");
		 // enter service provider char 
		 String c = input.next();
		 
		 System.out.println("\n********************************");
		 System.out.println("The Form");
		 double amount;
		 System.out.print("Enter amount:");
		 amount = input.nextDouble();
		 String fieldInput;
		 
		 if (c.equals("e"))
		 {
			 for(int i=0;i<data.e.service.size();i++)
			 {
				 if (data.e.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.e.service.get(i); // make choosen service = this service in Etisalat
					break;
				}
			 }

			 // display Etisalat form
			for(int i=1;i<data.e.form.fields.size();i++)
			{
				System.out.print("Enter "+data.e.form.fields.get(i)+":");
				fieldInput = input.next();
			}
			
		 }
		 else if (c.equals("o")) 
		 {
			 for(int i=0;i<data.o.service.size();i++)
			 {
				 if (data.o.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.o.service.get(i);  // make choosen service = this service in Orange
					break;
				}
			 }
			// display Orange form
			for(int i=1;i<data.o.form.fields.size();i++)
			{
				System.out.print("Enter "+data.o.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		}
		 else if (c.equals("w")) 
		 {
			 for(int i=0;i<data.w.service.size();i++)
			 {
				 if (data.w.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.w.service.get(i);  // make choosen service = this service in We
					break;
				}
			 }
			// display We form
			for(int i=1;i<data.w.form.fields.size();i++)
			{
				System.out.print("Enter "+data.w.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		}
		 else if (c.equals("v")) 
		 {
			 for(int i=0;i<data.v.service.size();i++)
			 {
				 if (data.v.service.get(i).getServiceName().equals(choosenService.getServiceName())) 
				 {
					choosenService = data.v.service.get(i);  // make choosen service = this service in Vodafone
				}
			 }
			// display Vodafone form
			for(int i=1;i<data.v.form.fields.size();i++)
			{
				System.out.print("Enter "+data.v.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		}
		 else if(c.equals("m"))
		 {
			 choosenService = data.mR.service; // make choosen service = this service in Monthly Receipt
			// display Monthly Receipt form
			 for(int i=1;i<data.mR.form.fields.size();i++)
			{
				System.out.print("Enter "+data.mR.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		 }
		 else if(c.equals("q"))
		 {
			 choosenService = data.qR.service; // make choosen service = this service in Quarter Receipt
			// display Quarter Receipt form
			 for(int i=1;i<data.qR.form.fields.size();i++)
			{
				System.out.print("Enter "+data.qR.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		 }
		 
		 else if(c.equals("s"))
		 {
			 choosenService = data.school.service; // make choosen service = this service in Schools
			// display Schools form
			 for(int i=1;i<data.school.form.fields.size();i++)
			{
				System.out.print("Enter "+data.school.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		 }
		 
		 else if(c.equals("c"))
		 {
			 choosenService = data.cancer.service;  // make choosen service = this service in Cancer Hospital
			// display Cancer Hospital form
			 for(int i=1;i<data.cancer.form.fields.size();i++)
			{
				System.out.print("Enter "+data.cancer.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		 }
		 
		 else if(c.equals("n"))
		 {
			 choosenService = data.ngo.service;  // make choosen service = this service in NGOs
			// display NGOs form
			 for(int i=1;i<data.ngo.form.fields.size();i++)
			{
				System.out.print("Enter "+data.ngo.form.fields.get(i)+":");
				fieldInput = input.next();
			}
		 }
		 
		 payMenu(choosenService, amount);
	}
	
	//choose which way to pay 
	public void payMenu(Services choosenService,double amount)
	{
		System.out.println("\n********************************");
		System.out.println("The default way is to pay via credit card");
		System.out.println("If you want another way to pay enter y if not enter n : ");
		String ch = input.next();
		if (ch.equals("y")) 
		{
			System.out.println("Payment Mnue:");
			System.out.println("1) Wallet");
			if (choosenService.getAcceptCash()==true) 
			{
				System.out.println("2) Cash On Delivery");
			}
			System.out.print("Enter num:");
			int payNum = input.nextInt();
			System.out.println();
			if (payNum==1) 
			{
				// make new transaction
				Transaction t = new Transaction();
				t.setService(choosenService);
				// apply decorator (add discounts)
				choosenService = new SpecificDiscount(choosenService.discount, choosenService);
				// if it is user first transaction
				if (data.user.transactions.size()==0) 
				{
					choosenService = new OverallDiscount(7, choosenService);
				}
				// decorator function 
				Double price = choosenService.cost();
				t.setMoney(price+amount);
				// check if there is enough money in wallet
				if (data.user.wallet.checkMoney(price+amount)==true) 
				{
					data.user.wallet.pay(price+amount);
					data.user.transactions.add(t);
				}
				else {
					System.out.println("No Enough Money in Wallet");
				}

			}
			if (payNum==2) 
			{
				// make new transaction
				Transaction t = new Transaction();
				t.setService(choosenService);
				// apply decorator (add discounts)
				choosenService = new SpecificDiscount(choosenService.discount, choosenService);
				// if it is user first transaction
				if (data.user.transactions.size()==0) 
				{
					choosenService = new OverallDiscount(7, choosenService);
				}
				// decorator function 
				Double price = choosenService.cost();
				t.setMoney(price+amount);
				Payment cash = new CacheOnDelivery(); 
				cash.pay(price+amount);
				data.user.transactions.add(t);
			}
		}
		
		else if (ch.equals("n")) 
		{
			// make new transaction
			Transaction t = new Transaction();
			t.setService(choosenService);
			// apply decorator (add discounts)
			choosenService = new SpecificDiscount(choosenService.discount, choosenService);
			// if it is user first transaction
			if (data.user.transactions.size()==0) 
			{
				choosenService = new OverallDiscount(7, choosenService);
			}
			// decorator function
			Double price = choosenService.cost();
			t.setMoney(price+amount);
			// check if there is enough money in credit card
			if (data.user.card.checkMoney(price+amount)==true) 
			{
				data.user.card.pay(price+amount);
				data.user.transactions.add(t);
			}
			else 
			{
				System.out.println("No Enough Money in Credit Card");
			}
		}
		
		System.out.println();
	}
	
	
	//option 2-----------------------------------------------------------------------------------------------
	public void searchforService ()
	{
		Search ser = new Search(data.services);
		System.out.print("Enter service name:");
		String n = input.next();
		System.out.println();
		ArrayList<Services> match = ser.serach(n);
		for (int i=0;i<match.size();i++)
		{
			 System.out.println(match.get(i).getServiceName());
		}
		System.out.println();
	}
	
	//option 3-----------------------------------------------------------------------------------------------
	public void addingFunds ()
	{
		System.out.println("Money in Wallet = "+ data.user.wallet.money);
		System.out.println("Money in Credit Card = "+ data.user.card.creditCardMoney);
		
		System.out.print("\nEnter amount you want to add in wallet: ");
		double mo = input.nextDouble();
		// check if there is enough money in credit card
		if (data.user.card.checkMoney(mo)==true) 
		{
			AddingFunds addingFunds = new AddingFunds();
			addingFunds.addFunds(data.user.card, data.user.wallet, mo);
			System.out.println("\nSucessfull Adding Funds");
			System.out.println("Money in Wallet After Adding Funds = "+ data.user.wallet.money);
			System.out.println("Money in Credit Card Adding Funds = "+ data.user.card.creditCardMoney);
		}
		else 
		{
			System.out.println("\nNo Enough Money in Credit Card");
		}

		System.out.println();
	}
	
	//option 4-----------------------------------------------------------------------------------------------
	public void showDiscounts ()
	{
		System.out.println("Etisalat");
		System.out.println("---------");
		for (int i=0;i<data.e.service.size();i++)
		{
			System.out.print(data.e.service.get(i).getServiceName()+"	");
			System.out.println(data.e.service.get(i).getDiscount()+"%");
		}
		System.out.println("\nOrange");
		System.out.println("--------");
		for (int i=0;i<data.o.service.size();i++)
		{
			System.out.print(data.o.service.get(i).getServiceName()+"	");
			System.out.println(data.o.service.get(i).getDiscount()+"%");
		}
		System.out.println("\nWe");
		System.out.println("-----");
		for (int i=0;i<data.w.service.size();i++)
		{
			System.out.print(data.w.service.get(i).getServiceName()+"	");
			System.out.println(data.w.service.get(i).getDiscount()+"%");
		}
		System.out.println("\nVodafone");
		System.out.println("----------");
		for (int i=0;i<data.v.service.size();i++)
		{
			System.out.print(data.v.service.get(i).getServiceName()+"	");
			System.out.println(data.v.service.get(i).getDiscount()+"%");
		}
		System.out.println("\nLandline for Monthly Receipt");
		System.out.println("-----------------");
		System.out.println("Discount = "+data.mR.service.getDiscount()+"%");
		
		System.out.println("\nLandline for Quarter Receipt");
		System.out.println("-----------------");
		System.out.println("Discount = "+data.qR.service.getDiscount()+"%");
		
		System.out.println("\nDonations for School");
		System.out.println("-----------------------");
		System.out.println("Discount = "+data.school.service.getDiscount()+"%");
		
		System.out.println("\nDonations for Cancer Hospital");
		System.out.println("-------------------------------");
		System.out.println("Discount = "+data.cancer.service.getDiscount()+"%");
		
		System.out.println("\nDonations for NGOs");
		System.out.println("---------------------");
		System.out.println("Discount = "+data.ngo.service.getDiscount()+"%");
		
		
		System.out.println();
	}
	
	//option 5-----------------------------------------------------------------------------------------------
	void askForRefund()
	{
		// if there are any transactions to refund
		if (data.user.transactions.size()!=0) 
		{
			// make new refund request
			RefundRequest refundRequest = new RefundRequest();
			System.out.println("All Transactions:");  // print all user transactions
			for (int i=0;i<data.user.transactions.size();i++)
			{
				System.out.print(i+1+")");
				System.out.print(data.user.transactions.get(i).ser.getServiceName()+ "	");
				System.out.println(data.user.transactions.get(i).money);
			}
			System.out.print("Choose which transactions you want to refund:");
			int tranNum = input.nextInt();
			// set selected transaction info to refund request info
			refundRequest.service = data.user.transactions.get(tranNum-1).ser;
			refundRequest.amount = data.user.transactions.get(tranNum-1).money;
			refundRequest.unique = String.valueOf(data.user.refundRequests.size()) + data.user.getUserName();
			refundRequest.user = data.user;
			
			// add request to user list
			data.user.addRequest(refundRequest);
			// add request to admin list
			data.admin.addRequest(refundRequest);
			
			System.out.println("\nSucessfull Refund Request");
			System.out.println();
		}
		else {
			System.out.println("No Transactions to Refund");
			System.out.println();
		}
	}

}

