package udel.cisc637.steven.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.dao.FavoritesDao;
import udel.cisc637.steven.dao.UsersDao;
import udel.cisc637.steven.model.FavoritesModel;
import udel.cisc637.steven.model.UsersModel;
import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.UsersView;
import udel.cisc637.steven.view.SPCView;

public class UsersViewController {
	
	public void controlAllUsersView(int choice){
		
		if(Main.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: previouspage(Main.CurrentPageNumber);
					break;
				case 3: seeUser();
					break;
				case 4: goBackToMainMenu();
					break;
				case 5: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
			}
		}else{
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: seeUser();
					break;
				case 3: goBackToMainMenu();
					break;
				case 4: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
			}
		}
	}
	
	public void controlAllUsersViewAdmin(int choice){
		
		if(Main.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: previouspage(Main.CurrentPageNumber);
					break;
				case 3: seeUser();
					break;
				case 4: addUser(null);
					break;
				case 5: deleteUser(null);
					break;
				case 6: updateUser(null);
					break;
				case 7: goBackToMainMenu();
					break;
				case 8: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
			}
		}else{
			switch(choice){
			case 1: nextpage(Main.CurrentPageNumber);
				break;
			case 2: seeUser();
				break;
			case 3: addUser(null);
				break;
			case 4: deleteUser(null);
				break;
			case 5: updateUser(null);
				break;
			case 6: goBackToMainMenu();
				break;
			case 7: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
		}
		}
	}

	
	public void controlUserFromEmailView(int choice){
		if(Main.user.isAdmin()){
			switch(choice){
			case 1: deleteUser(Main.Email);
				break;
			case 2: updateUser(Main.Email);
				break;
			case 3: goBackToUsers();// go back to subcategory
				break;
			case 4: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
			}
		}else{
			switch(choice){
			case 1: goBackToUsers();// go back to subcategory
				break;
			case 2: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
			}
		}
		
		
	}
	
	public void seeUser(){
		
		UsersView usersView = new UsersView();
		usersView.displayUserFromEmail(null);
	}
	
	public void goBackToUsers(){
		
		UsersView usersView = new UsersView();
		usersView.displayUserFromEmail(Main.Email);
	}

	public void goBackToMainMenu(){
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.displayMainMenu(Main.user);
	}
	
	public void nextpage(int currentPage){
		
		UsersView usersView = new UsersView();
		Main.setCurrentPageNumber(Main.CurrentPageNumber+1);
		usersView.displayAllUsers(5, Main.CurrentPageNumber);
	}
	
	public void previouspage(int currentPage){

		UsersView usersView = new UsersView();
		Main.setCurrentPageNumber(Main.CurrentPageNumber-1);
		usersView.displayAllUsers(5, Main.CurrentPageNumber);
	}

	private void addUser(String Email) {
		// TODO Auto-generated method stub
		UsersDao usersDao = new UsersDao();
		UsersView usersView = new UsersView();
		UsersModel user = new UsersModel();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			if(Email==null){
				
				System.out.print("Please Enter Email: ");
				Email = br.readLine();
				if(Email!=null){
					user.setEmail(Email);
				}
			}
			
			System.out.print("Please Enter UserName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String UserName = br.readLine();
			if(UserName!=null){
				user.setName(Email);
			}
			System.out.print("Please Enter Password: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String password = br.readLine();
			if(password!=null){
				user.setPassword(password);
			}
			
			System.out.print("Please Enter Admin: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			Boolean Admin = Boolean.parseBoolean(br.readLine());
			if(Admin!=null){
				user.setAdmin(Admin);
			}
			
			if(usersDao.getUser(Email)!=null){
				System.out.print("User Exist! ");
			}else{
				
				usersDao.addUser(user);
			}
			
			usersView.displayAllUsers(5, Main.CurrentPageNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("Please input a nubmer as an Email");
		}
		
		
	
	}
	
	private void deleteUser(String Email) {
		// TODO Auto-generated method stub
		UsersDao usersDao = new UsersDao();
		UsersView usersView = new UsersView();
		UsersModel user = new UsersModel();
		if(Email==null){
			try {
				System.out.print("Please Enter Email: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				Email = br.readLine();
				if(Email!=null){
					user.setEmail(Email);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e){
				System.out.println("Please input a nubmer as an Email");
			}
		}
		if(usersDao.getUser(Email)!=null){
			usersDao.deleteUser(Email);
		}else{
			System.out.print("Already Exist! ");
		}
		usersView.displayAllUsers(5, Main.CurrentPageNumber);
	}
	
	private void updateUser(String Email) {
		// TODO Auto-generated method stub
		UsersDao usersDao = new UsersDao();
		UsersView usersView = new UsersView();
		UsersModel user = new UsersModel();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			if(Email==null){
				
				System.out.print("Please Enter Email: ");
				Email = br.readLine();
				if(Email!=null){
					user.setEmail(Email);
				}
			}
			
			System.out.print("Please Enter UserName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String UserName = br.readLine();
			if(UserName!=null){
				user.setName(Email);
			}
			System.out.print("Please Enter Password: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String password = br.readLine();
			if(password!=null){
				user.setPassword(password);
			}
			
			System.out.print("Please Enter Admin: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			Boolean Admin = Boolean.parseBoolean(br.readLine());
			if(Admin!=null){
				user.setAdmin(Admin);
			}
			if(usersDao.getUser(Email)!=null){
				usersDao.updateUser(user);
			}else{
				System.out.print("Wrong Email! ");
			}
			
			usersView.displayAllUsers(5, Main.CurrentPageNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("Please input a nubmer as an Email");
		}
		
	}
}
