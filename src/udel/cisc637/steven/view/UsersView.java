package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.UsersViewController;
import udel.cisc637.steven.dao.UsersDao;
import udel.cisc637.steven.model.UsersModel;

public class UsersView {
	
	public void displayAllUsers(int items, int page) {
		// TODO Auto-generated method stub
		UsersDao UsersController = new UsersDao();
		List<UsersModel> usersList= UsersController.getAllUsers();
		
		System.out.print("\n");
		System.out.println("===Users===");
		for(UsersModel e:usersList){
			System.out.println(e.getName());
		}
		System.out.println("===Page"+page+"===");
		System.out.print("\n");
		
		int options;
		
		if(Main.Admin&&Main.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Detail.");
			System.out.println("4. Add.");
			System.out.println("5. Delete.");
			System.out.println("6. Update.");
			System.out.println("7. Go Back.");
			System.out.println("8. Quit");
			options=8;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			UsersViewController usersViewController = new UsersViewController();
			usersViewController.controlAllUsersViewAdmin(choice);
		}
		
		if(Main.Admin&&Main.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Detail.");
			System.out.println("3. Add.");
			System.out.println("4. Delete.");
			System.out.println("5. Update.");
			System.out.println("6. Go Back.");
			System.out.println("7. Quit");
			options=7;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			UsersViewController usersViewController = new UsersViewController();
			usersViewController.controlAllUsersViewAdmin(choice);
		}
		
		
		if(!Main.Admin&&Main.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Detail.");
			System.out.println("4. Go Back.");
			System.out.println("5. Quit");
			options=5;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			UsersViewController usersViewController = new UsersViewController();
			usersViewController.controlAllUsersView(choice);
		}
		
		if(!Main.Admin&&Main.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Detail.");
			System.out.println("3. Go Back.");
			System.out.println("4. Quit");
			options=4;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			UsersViewController usersViewController = new UsersViewController();
			usersViewController.controlAllUsersView(choice);
		}
	}

	public void displayUserFromEmail(String Email) {
		
	    try {
	    	
	    	if(Email==null){
				System.out.print("Please Enter ProductID: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				Email = br.readLine();
			}
	    	
	    	UsersDao usersDao = new UsersDao();
			UsersModel user = usersDao.getUser(Email);
			
			System.out.print("\n");
			System.out.println("===User===");
			System.out.println("User Name: "+user.getName());
			System.out.println("Password: "+user.getPassword());
			System.out.println("Admin: "+user.isAdmin());
			System.out.println("=============");
			System.out.print("\n");
			
			int options;
			if(Main.Admin){
				System.out.println("===Menu===");
				System.out.println("1. Delete");
				System.out.println("2. Update");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				options=3;
			}else{
				System.out.println("===Menu===");
				System.out.println("1. Go Back.");
				System.out.println("2. Quit");
				options=2;
			}
			Main.setEmail(Email);
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			UsersViewController usersViewController = new UsersViewController();
			usersViewController.controlUserFromEmailView(choice);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
	}
	public void login(){
		UsersDao userDao = new UsersDao();
		MainMenuView mmv = new MainMenuView();
		String name = null;
		String pass = null;
		UsersModel user = new UsersModel();
		try {
			System.out.print("Please Enter Your UserName: ");
			BufferedReader username = new BufferedReader(new InputStreamReader(System.in));
			name = username.readLine();
			user.setName(name);
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    	System.exit(1);
	    }
		
		try {
			System.out.print("Please Enter Your Password: ");
			BufferedReader password = new BufferedReader(new InputStreamReader(System.in));
			pass = password.readLine();
			user.setPassword(pass);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    	System.exit(1);
	    }
		
		userDao.login(user);
		mmv.displayMainMenu(Main.getUserName());
	}
	
	public void logout(){
		UsersDao UsersController = new UsersDao();
		MainMenuView mmv = new MainMenuView();
		UsersController.logout();
		mmv.displayGuestMainMenu();
	}
	
}
