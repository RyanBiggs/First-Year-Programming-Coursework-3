import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class console {
	private static final Scanner S = new Scanner(System.in);
	
	private static final Pump[] pumps = new Pump[5];
	private static final List<Receipt> receipts = new ArrayList<Receipt>();
	public static void main(String[] args) throws Exception 
	{
	    	loadPumps();
	    //Main Menu
		String choice = "";
		do {
			System.out.println("-- MAIN MENU --");
			System.out.println("1 - Purchase Petrol");
			System.out.println("2 - Ready Pumps");
			System.out.println("3 - View and Reset Pumps");
			System.out.println("4 - Manager Reports");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");
			choice = S.next();

			switch (choice) {
				case "1" : {
				    	purchasePetrol();
					break;
				}
				case "2" : {
				    	readyPumps();
					break;
				}
				case "3" : {
				    	viewResetPumps();
					break;
				}
				case "4" : {
				    	managerReports();
					break;
				}
			}
		} while (!choice.toUpperCase().equals("Q"));

		
		S.close();

		System.out.println("Bye Bye :)");	
		System.exit(0);
	} //Assigns pumps and nozzles their attributes 
	private static void loadPumps() {
	    Pump pump1 = new Pump();	    
	    pump1.setNo(1);
	    pump1.setMode(Mode.StandBy);
	    Nozzle n1 = new Nozzle();
	    n1.setName("Texaco");
	    n1.setPrice(5.50);
	    n1.setType("Diesel");
	    Nozzle n2 = new Nozzle();
	    n2.setName("Caltex");
	    n2.setPrice(4.76);
	    n2.setType("Unleaded");
	    Nozzle[] noz1 = {n1,n2};
	    pump1.setNozzles(noz1);
	    {
	    };
	    pumps[0] = pump1;
	    
	    
	    
	    
	    Pump pump2 = new Pump();
	    pump2.setNo(2);
	    pump2.setMode(Mode.StandBy);
	    Nozzle n3 = new Nozzle();
	    n3.setName("Maxol");
	    n3.setPrice(6.45);
	    n3.setType("Diesel");
	    Nozzle n4 = new Nozzle();
	    n4.setName("Pale");
	    n4.setPrice(5.34);
	    n4.setType("Unleaded");
	    Nozzle[] noz2 = {n3,n4};
	    pump2.setNozzles(noz2);
	    {	
	    };
	    pumps[1] = pump2;
	    
	    
	    

	    
	    Pump pump3 = new Pump();
	    pump3.setNo(3);
	    pump3.setMode(Mode.StandBy);
	    Nozzle n5 = new Nozzle();
	    n5.setName("BP");
	    n5.setPrice(6.43);
	    n5.setType("Diesel");
	    Nozzle n6 = new Nozzle();
	    n6.setName("Esso");
	    n6.setPrice(4.56);
	    n6.setType("Unleaded");
	    Nozzle[] noz3 = {n5,n6};
	    pump3.setNozzles(noz3); 
	    {
	    };
	    pumps[2] = pump3;
	    
	    
	    Pump pump4 = new Pump();
	    pump4.setNo(4);
	    pump4.setMode(Mode.StandBy);
	    Nozzle n7 = new Nozzle();
	    n7.setName("Total");
	    n7.setPrice(4.67);
	    n7.setType("Diesel");
	    Nozzle n8 = new Nozzle();
	    n8.setName("Murco");
	    n8.setPrice(5.45);
	    n8.setType("Unleaded");
	    Nozzle[] noz4 = {n7,n8};
	    pump4.setNozzles(noz4); 
	    {
	    };
	    pumps[3] = pump4;
	    
	    
	    
	    Pump pump5 = new Pump();
	    pump5.setNo(5);
	    pump5.setMode(Mode.StandBy);
	    Nozzle n9 = new Nozzle();
	    n9.setName("Jet");
	    n9.setPrice(5.43);
	    n9.setType("Diesel");
	    Nozzle n10 = new Nozzle();
	    n10.setName("Shell");
	    n10.setPrice(5.43);
	    n10.setType("Unleaded");
	    Nozzle[] noz5 = {n9,n10};
	    pump5.setNozzles(noz5); 
	    {
	    };
	    pumps[4] = pump5;   
	    
	    
	    
	}
	public static void purchasePetrol()
	{//Create receipt and log date and time
	    Receipt r = new Receipt();
	    r.dateTime = new Date();
	    System.out.print("What Number Pump? (1-5) : ");
	    String choice = S.next();
	    if (Integer.parseInt(choice) < 6)
	    {	//Check if pump is ready
		Pump choosenPump = pumps[Integer.parseInt(choice)-1];		
		if(choosenPump.getMode() == Mode.Ready)
		{
		    //Ask the customer for their choices
		    System.out.print("Diesel[0] Or Unleaded[1]? : ");
		    choice = S.next();
		    int number = 0;
		    if(Integer.parseInt(choice) == 0)
		    {
			number = 0;			
		    }
		    else
		    {
			number = 1;
		    }
		    r.fuelType = choosenPump.getNozzle(number).getType();
		    System.out.print("How many litres? : ");
		    choice = S.next();
		    r.Litres = Integer.parseInt(choice);
		    r.Cost = r.Litres * choosenPump.getNozzle(1).getPrice();
		    receipts.add(r);
		    
		    System.out.println(String.format("Your total to pay is £%.2f",r.Cost));
		    System.out.println("You may now refuel your vehicle");
		}
		else
		{//if pump isn't ready
		    System.out.println("Pump not ready");
		}		
	    }
	    else
	    {//if customer chooses a pump out of the range of 1-5
		System.out.println("Invalid choice");
	    }	    
	}
	    	
	public static void readyPumps()
	{
	    
	    System.out.print("What Number Pump Would You Like To Ready? (1-5) : ");
	    //Set what ever pump is given to ready 
	    String choice = S.next();
	    switch (choice) {
		case "1" : {
		    pumps[0].setMode(Mode.Ready);
		    System.out.println("Pump 1 Ready");
			break;
		}
		case "2" : {
		    pumps[1].setMode(Mode.Ready);
		    System.out.println("Pump 2 Ready");
			break;
		}
		case "3" : {
		    pumps[2].setMode(Mode.Ready);
		    System.out.println("Pump 3 Ready");
			break;
		}
		case "4" : {
		    pumps[3].setMode(Mode.Ready);
		    System.out.println("Pump 4 Ready");
			break;
		}
		case "5" : {
		    pumps[4].setMode(Mode.Ready);
		    System.out.println("Pump 5 Ready");
			break;
		}
		default: {
		    System.out.println("Invalid choice");
		}
	    }    
	}	
	public static void viewResetPumps()
	{ //reset all pumps
	    System.out.println(String.format("Pumps 1 Mode:%s",pumps[0].getMode().toString()));
	    System.out.println(String.format("Pumps 2 Mode:%s",pumps[1].getMode().toString()));
	    System.out.println(String.format("Pumps 3 Mode:%s",pumps[2].getMode().toString()));
	    System.out.println(String.format("Pumps 4 Mode:%s",pumps[3].getMode().toString()));
	    System.out.println(String.format("Pumps 5 Mode:%s",pumps[4].getMode().toString()));
	    
	    System.out.println("Reset all pumps? Y/N : ");
	    String choice = S.next().toUpperCase();
	    if (choice.equals("Y"))
	    {	
    	    pumps[0].setMode(Mode.StandBy);
    	    pumps[1].setMode(Mode.StandBy);
    	    pumps[2].setMode(Mode.StandBy);
    	    pumps[3].setMode(Mode.StandBy);
    	    pumps[4].setMode(Mode.StandBy);
    	    System.out.print("Pumps Reset");
	    }
	}
	
	public static void managerReports()
	{ 
	    int i = 1;
	    double totalCost = 0;
	    int totalLitres = 0;
	    int totalDiesel = 0;
	    int totalUnleaded = 0;
	    if(receipts.size() > 0)
	    {//Report menu
	    System.out.println("1 - Print all reports");
	    System.out.println("2 - Print specifc report");
	    System.out.print("Pick : ");
	    String choice = S.next();

		switch (choice) {
			case "1" : {
			    for(Receipt r : receipts)
			    {//This will print out all available receipts
			    System.out.println("");
				System.out.println(String.format("Receipt No:%s",i));
				System.out.println(String.format("Fuel Type:%s",r.fuelType));
				System.out.println(String.format("DateTime:%s",r.dateTime));
				System.out.println(String.format("Litres:%s",r.Litres));
				System.out.println(String.format("Cost:£%.2f",r.Cost));
				System.out.println("");
				i++;		
				//This will provide the totals for price, litres, diesel and unleaded 
				totalCost += r.Cost;
				totalLitres += r.Litres;
				if(r.fuelType == "Diesel")
				{
				    totalDiesel += r.Litres;
				}
				else if(r.fuelType == "Unleaded")
				{
				    totalUnleaded += r.Litres;
				}
			    }			    // And then print them out
			    System.out.println(String.format("Total earnings from today:£%.2f",totalCost));
			    System.out.println("");
			    System.out.println(String.format("Total Litres sold from today:%s",totalLitres));
			    System.out.println("");
			    System.out.println(String.format("Total Diesel sold from today:%s",totalDiesel));
			    System.out.println("");
			    System.out.println(String.format("Total Unleaded sold from today:%s",totalUnleaded));
			    break;
			}
			case "2" : { //This will print out all receipts assocaiated with the given pump number
			    	Integer choiceNo = Integer.parseInt(S.next());
			    	if(receipts.size() > (choiceNo-1))
			    	{
			    	Receipt r = (Receipt) receipts.toArray()[choiceNo -1];
			    System.out.println("");
				System.out.println(String.format("Receipt No:%s",choiceNo));
				System.out.println(String.format("Fuel Type:%s",r.fuelType));
				System.out.println(String.format("DateTime:%s",r.dateTime));
				System.out.println(String.format("Litres:%s",r.Litres));
				System.out.println(String.format("Cost:£%.2f",r.Cost));
				System.out.println("");
			    	}
			    	break;
			}
		}
	    }
	    else
	    {//If nothing has been sold yet
		System.out.println("There are no reports at this current time");
	    }
	}
}