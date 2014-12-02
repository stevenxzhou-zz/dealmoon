package udel.cisc637.steven.view;

import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.FavoritesViewController;
import udel.cisc637.steven.dao.FavoritesDao;
import udel.cisc637.steven.dao.ProductsDao;
import udel.cisc637.steven.model.FavoritesModel;

public class FavoritesView {
	
	public void displayAllFavorites() {
		// TODO Auto-generated method stub
		FavoritesDao favoritesDao = new FavoritesDao();
		List<FavoritesModel> favoritesList= favoritesDao.getAllFavorites();
		ProductsDao productsController = new ProductsDao();
		System.out.print("\n");
		System.out.println("===Favorites===");
		for(FavoritesModel e:favoritesList){
			String productName=productsController.getProduct( e.getProductID()).getProductName();
			System.out.println("Product Name:"+productName);
			System.out.println("Store Name:"+e.getStoreName());
		}
		System.out.println("=============");
		System.out.print("\n");
		
		System.out.println("===Menu===");
		System.out.println("1. Delete Favorites.");
		System.out.println("2. Go Back.");
		System.out.println("3. Quit");
		
		int options=3;
		
		MainMenuView mainMenuView = new MainMenuView();
		int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
		
		FavoritesViewController favoritesViewController = new FavoritesViewController();
		favoritesViewController.controlAllFavoritesView(choice);
	}
}
