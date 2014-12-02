package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.MainMenuController;
import udel.cisc637.steven.dao.MPCDao;
import udel.cisc637.steven.model.UsersModel;

public class MainMenuView {
	
	MainMenuController mainMenuController = new MainMenuController();
	
	public void displayMainMenu(UsersModel user){
		if(user.isAdmin()){
			displayAdminMainMenu(user.getName());
		}else if(!user.isAdmin()){
			displayUserMainMenu(user.getName());
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
    	
		int choice=readchoice(Main.AllowedInputTimes,5);
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

		int choice=readchoice(Main.AllowedInputTimes,6);
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
		
		int choice=readchoice(Main.AllowedInputTimes,6);
	    mainMenuController.adminMenu(choice);
	}
	
	int choice;
	// common method for reading choices the user input
	public int readchoice(int times, int options){
		System.out.print("Please Enter Your Choice: ");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try {
	    	choice = Integer.parseInt(br.readLine());
	    	
	    	if(choice<=options){
	    		return choice;
	    	}else if(times>0){
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
	    	System.out.println("IO error trying to read your name!");
	    	readchoice(times,options);
		}
		return choice;
	}
}
