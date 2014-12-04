package udel.cisc637.steven.controller;

import app.start.Start;
import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MPCView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.StoresView;
import udel.cisc637.steven.view.UsersView;

public class MainMenuController {
	
	ProductsView productsView = new ProductsView();
	StoresView storesView = new StoresView();
	MPCView mpcView = new MPCView();
	FavoritesView favoritesView = new FavoritesView();
	UsersView usersView = new UsersView();
	
	
	public void guestMenu(int choice){
		switch(choice){
		case 1: productsView.displayAllProducts(5,1);
			break;
		case 2: storesView.displayAllStores(5,1);
			break;
		case 3: mpcView.displayAllMainCategories();
			break;
		case 4: usersView.login();
			break;
		case 5: System.exit(1);
			break;
		default:
			MainMenuView mainMenuView = new MainMenuView();
			mainMenuView.displayMainMenu(Start.UserName);
			
		}
	}
	
	public void userMenu(int choice){
		switch(choice){
		case 1: productsView.displayAllProducts(5,1);
			break;
		case 2: storesView.displayAllStores(5,1);
			break;
		case 3: mpcView.displayAllMainCategories();
			break;
		case 4: favoritesView.displayAllFavorites();
			break;
		case 5: usersView.logout();
			break;
		case 6: System.exit(1);
			break;
		default:
			MainMenuView mainMenuView = new MainMenuView();
			mainMenuView.displayMainMenu(Start.UserName);
		}
	}
	
	public void adminMenu(int choice){
		switch(choice){
		case 1: productsView.displayAllProducts(5,1);
			break;
		case 2: storesView.displayAllStores(5,1);
			break;
		case 3: mpcView.displayAllMainCategories();
			break;
		case 4: usersView.displayAllUsers(5,1);
			break;
		case 5: usersView.logout();
			break;
		case 6: System.exit(1);
			break;
		default:
			MainMenuView mainMenuView = new MainMenuView();
			mainMenuView.displayMainMenu(Start.UserName);
		}
	}
}
