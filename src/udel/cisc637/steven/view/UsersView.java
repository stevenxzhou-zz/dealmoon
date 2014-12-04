package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import app.start.Start;

import udel.cisc637.steven.controller.UsersViewController;
import udel.cisc637.steven.dao.UsersDao;
import udel.cisc637.steven.model.UsersModel;
import udel.cisc637.steven.utility.PageInfo;

public class UsersView {
	
	public void displayAllUsers(int items, int page) {
		// TODO Auto-generated method stub
		UsersDao UsersController = new UsersDao();
		List<UsersModel> usersList= UsersController.getAllUsers();
		
		PageInfo pageinfo = new PageInfo(usersList,5);
		
		System.out.print("\n");
		System.out.println("===Users===");
		for(UsersModel e:usersList){
			System.out.println(e.getEmail());
		}
		System.out.println("===Page"+page+"===");
		System.out.print("\n");
		
		int options;
		int choice;

		if(Start.Admin&&Start.CurrentPageNumber>1&&Start.CurrentPageNumber!=pageinfo.getMaxPages()){
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
			choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			
		}else if(Start.Admin&&Start.CurrentPageNumber==1&&pageinfo.getMaxPages()>1){
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
			choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
		
		}else{
			System.out.println("===Menu===");
			System.out.println("1. See Detail.");
			System.out.println("2. Add.");
			System.out.println("3. Delete.");
			System.out.println("4. Update.");
			System.out.println("5. Go Back.");
			System.out.println("6. Quit");
			options=6;
			
			MainMenuView mainMenuView = new MainMenuView();
			choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
		}
		
		UsersViewController usersViewController = new UsersViewController();
		usersViewController.controlAllUsersViewAdmin(choice, pageinfo.getMaxPages(),pageinfo.getMaxItems());
	}

	public void displayUserFromEmail(String Email) {
	    	
	    	if(Email==null){
				MainMenuView mainMenuView = new MainMenuView();
				Email=mainMenuView.readstring(Start.AllowedInputTimes, "Email");
			}
	    	
	    	UsersDao usersDao = new UsersDao();
			UsersModel user = usersDao.getUser(Email);
			
			System.out.print("\n");
			System.out.println("===User===");
			System.out.println("User Name: "+user.getName());
			System.out.println("Email: "+user.getEmail());
			System.out.println("Password: "+user.getPassword());
			System.out.println("Admin: "+user.isAdmin());
			System.out.println("=============");
			System.out.print("\n");
			
			int options;
			if(Start.Admin){
				System.out.println("===Menu===");
				System.out.println("1. Delete");
				System.out.println("2. Update");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				options=4;
			}else{
				System.out.println("===Menu===");
				System.out.println("1. Go Back.");
				System.out.println("2. Quit");
				options=2;
			}
			Start.setEmail(Email);
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			UsersViewController usersViewController = new UsersViewController();
			usersViewController.controlUserFromEmailView(choice);
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
		mmv.displayMainMenu(Start.getUserName());
	}
	
	public void logout(){
		UsersDao UsersController = new UsersDao();
		MainMenuView mmv = new MainMenuView();
		UsersController.logout();
		mmv.displayGuestMainMenu();
	}
	
}
