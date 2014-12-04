package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

import app.start.Start;

import udel.cisc637.steven.controller.MainMenuController;
import udel.cisc637.steven.model.UsersModel;

public class MainMenuView {
	
	MainMenuController mainMenuController = new MainMenuController();
	
	public void displayMainMenu(String UserName){
		Start.SubCategoryName=null;
		Start.StoreName=null;
		Start.ProductID=-1;
		
		if(Start.Admin){
			displayAdminMainMenu(UserName);
		}else if(Start.login){
			displayUserMainMenu(UserName);
		}else{
			displayGuestMainMenu();
		}
	}
	public void displayGuestMainMenu(){
		
    	System.out.print("\n");
		System.out.println("Welcome to Dealmoon, Guest!");
		System.out.println("1. Check out the Products.");
		System.out.println("2. Check out the Stores.");
		System.out.println("3. Check out the Catetogories.");
		System.out.println("4. User/Admin Login.");
		System.out.println("5. Quit");
    	System.out.print("\n");
    	
		int choice=readchoice(Start.AllowedInputTimes,5);
	    mainMenuController.guestMenu(choice); 
	}
	
	public void displayUserMainMenu(String User){
		System.out.print("\n");
		System.out.println("Welcome to Dealmoon, "+User+"(User)!");
		System.out.println("1. Check out the Products.");
		System.out.println("2. Check out the Stores.");
		System.out.println("3. Check out the Catetogories.");
		System.out.println("4. My Favorites.");
		System.out.println("5. Logout.");
		System.out.println("6. Quit");
		System.out.print("\n");

		int choice=readchoice(Start.AllowedInputTimes,6);
	    mainMenuController.userMenu(choice);
	}
	
	public void displayAdminMainMenu(String User){
		System.out.print("\n");
		System.out.println("Welcome to Dealmoon, "+User+"(Administrator)!");
		System.out.println("1. Manage Products.");
		System.out.println("2. Manage Stores.");
		System.out.println("3. Manage Catetogories.");
		System.out.println("4. Manage Users.");
		System.out.println("5. Logout.");
		System.out.println("6. Quit");
		System.out.print("\n");
		
		int choice=readchoice(Start.AllowedInputTimes,6);
	    mainMenuController.adminMenu(choice);
	}
	
	int choice;
	// common method for reading choices the user input
	public int readchoice(int times, int options){
		if(times>0){
			System.out.print("Please Enter Your Choice: ");
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    try {
		    	choice = Integer.parseInt(br.readLine());
		    	
		    	if(0<choice&&choice<=options){
		    		return choice;
		    	}else if(times>0||choice<0){
		    		times--;
		    		System.out.println("Wrong Choice! You have "+times+" times to try");
		    		readchoice(times,options);
		    	}else{
		    		System.exit(1);
		    	}
				
			} catch (NumberFormatException e) {
				times--;
		    	System.out.println("Please Input a Number, You have "+times+" times to try");
		    	readchoice(times,options);
		    	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				times--;
		    	System.out.println("IO error!");
		    	readchoice(times,options);
			}
		}else{
			System.out.println("Sorry! You have make 3 mistakes, You will be sent to main menu!");
			displayMainMenu(Start.UserName);
		}
		
		return choice;
	}
	

	
	String string;
	public String readstring(int times, String name){
		if(times>0){
			System.out.print("Please Enter The "+name+":");
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    try {
				string = br.readLine();
				if(isNumeric(string)){
					times--;
					System.out.println("Please Input a String! Not a Number! You have "+times+" times to try");
					readstring(times,name);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				times--;
				System.out.println("IO Error!");
				readstring(times,name);
			} catch (IllegalFormatException e){
				times--;
				System.out.println("Please Input a String! You have "+times+" times to try");
				readstring(times,name);
			}
			
		}else{
			System.out.println("Sorry! You have make 3 mistakes, You will be sent to main menu!");
			displayMainMenu(Start.UserName);
		}
		return string;
	}
	
	
	int id;
	// common method for reading choices the user input
	public int readid(int times, String name){
		if(times>0){
			System.out.print("Please Enter The "+name+":");
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    try {
		    	id = Integer.parseInt(br.readLine());
		    	if(0<id){
		    		return id;
		    	}else if(times>0||id<0){
		    		times--;
		    		System.out.println("Wrong Choice! You have "+times+" times to try");
		    		readid(times,name);
		    	}else{
		    		System.exit(1);
		    	}
				
			} catch (NumberFormatException e) {
				times--;
		    	System.out.println("Please Input a Number, You have "+times+" times to try");
		    	readid(times,name);
		    	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				times--;
		    	System.out.println("IO error!");
		    	readid(times,name);
			}
		}else{
			System.out.println("Sorry! You have make 3 mistakes, You will be sent to main menu!");
			displayMainMenu(Start.UserName);
		}
		
		return id;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
