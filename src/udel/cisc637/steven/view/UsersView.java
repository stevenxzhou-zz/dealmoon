package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.UsersController;
import udel.cisc637.steven.model.UsersModel;

public class UsersView {
	
	
	
	public void displayAllUsers() {
		// TODO Auto-generated method stub
		UsersController UsersController = new UsersController();
		MainMenuView mmv = new MainMenuView();
		List<UsersModel> usersList= UsersController.getAllUsers();

		for(UsersModel e:usersList){
			System.out.println(e.getName());
		}
	}
	
	public void login(){
		UsersController UsersController = new UsersController();
		MainMenuView mmv = new MainMenuView();
		String name = null;
		String pass = null;
		
		try {
			System.out.print("Please Enter Your UserName: ");
			BufferedReader username = new BufferedReader(new InputStreamReader(System.in));
			name = username.readLine();
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    	System.exit(1);
	    }
		
		try {
			System.out.print("Please Enter Your Password: ");
			BufferedReader password = new BufferedReader(new InputStreamReader(System.in));
			pass = password.readLine();
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    	System.exit(1);
	    }
		
		UsersController.login(name, pass);
		
		if(Main.isAdmin){
			mmv.displayAdminMainMenu(name);
		}else if(Main.isUser){
			mmv.displayUserMainMenu(name);
		}else{
			System.out.print("!No Such User!");
			mmv.displayGuestMainMenu();
		}
	}
	
	public void logout(){
		UsersController UsersController = new UsersController();
		MainMenuView mmv = new MainMenuView();
		UsersController.logout();
		mmv.displayGuestMainMenu();
	}
	
}
