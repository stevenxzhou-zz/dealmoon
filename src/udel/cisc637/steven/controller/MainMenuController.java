package udel.cisc637.steven.controller;

import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MpcView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.StoresView;
import udel.cisc637.steven.view.UsersView;

public class MainMenuController {
	
	ProductsView pv = new ProductsView();
	StoresView sv = new StoresView();
	MpcView mv = new MpcView();
	FavoritesView fv = new FavoritesView();
	UsersView uv = new UsersView();
	
	public void guestMenu(int choice){
		switch(choice){
		case 1: pv.displayAllProducts(5,1);
			break;
		case 2: sv.displayAllStores(5,1);
			break;
		case 3: mv.displayAllMainCategories();
			break;
		case 4: uv.login();
			break;
		case 5: System.exit(1);
			break;
		default:
			System.out.println("No Such Choice!");
			
		}
	}
	
	public void userMenu(int choice){
		switch(choice){
		case 1: pv.displayAllProducts(5,1);
			break;
		case 2: sv.displayAllStores(5,1);
			break;
		case 3: mv.displayAllMainCategories();
			break;
		case 4: fv.displayAllFavorites();
			break;
		case 5: uv.logout();
			break;
		case 6: System.exit(1);
			break;
		default:
			System.out.println("No Such Choice!");
		}
	}
	
	public void adminMenu(int choice){
		switch(choice){
		case 1: pv.displayAllProducts(5,1);
			break;
		case 2: sv.displayAllStores(5,1);
			break;
		case 3: mv.displayAllMainCategories();
			break;
		case 4: uv.displayAllUsers();
			break;
		case 5: uv.logout();
			break;
		case 6: System.exit(1);
			break;
		default:
			System.out.println("No Such Choice!");
		}
	}
}
