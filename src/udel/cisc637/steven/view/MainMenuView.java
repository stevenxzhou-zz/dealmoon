package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import udel.cisc637.steven.controller.MainMenuController;
import udel.cisc637.steven.controller.MpcController;

public class MainMenuView {
	
	MainMenuController mmc = new MainMenuController();
	
	public void displayGuestMainMenu(){
		System.out.println("Welcome to Dealmoon, Guest!");
		System.out.println("1. Check out the Products.");
		System.out.println("2. Check out the Stores.");
		System.out.println("3. Check out the Catetogories.");
		System.out.println("4. User/Admin Login.");
		
		System.out.print("Please Enter Your Choice: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
	    int choice=0;
	    
	    try {
	    	choice = Integer.parseInt(br.readLine());
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    	System.exit(1);
	    }
	    
	    mmc.guestMenu(choice);  
	}
	
	public void displayUserMainMenu(String User){
		System.out.println("Welcome to Dealmoon, "+User+"!");
		System.out.println("1. Check out the Products.");
		System.out.println("2. Check out the Stores.");
		System.out.println("3. Check out the Catetogories.");
		System.out.println("4. My Favorites.");
		System.out.println("5. Logout.");
		
		System.out.print("Please Enter Your Choice: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
	    String choice = null;
	    try {
	    	choice = br.readLine();
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    	System.exit(1);
	    }
	}
	
	public void displayAdminMainMenu(String User){
		
		System.out.println("Welcome to Dealmoon, "+User+"(Admin)!");
		System.out.println("1. Manage Products.");
		System.out.println("2. Manage Stores.");
		System.out.println("3. Manage Catetogories.");
		System.out.println("4. Manage Users.");
		System.out.println("5. Logout.");
		
		System.out.print("Please Enter Your Choice: ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    String choice = null;
	    try {
	    	choice = br.readLine();
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    	System.exit(1);
	    }
	}
}
