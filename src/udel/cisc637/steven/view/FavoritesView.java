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
		List<FavoritesModel> favoritesList= favoritesDao.getFavoritesByEmail(Main.getEmail());
		ProductsDao productsController = new ProductsDao();
		System.out.print("\n");
		System.out.println("===Favorites===");
		System.out.println(">>Favorite Products");
		for(FavoritesModel e:favoritesList){
			String productName=productsController.getProduct( e.getProductID()).getProductName();
			
			if(productName!=null){
				System.out.println(e.getProductID()+" "+productName);
			}
		}
		
		System.out.println(">>Favorite Stores");
		for(FavoritesModel e:favoritesList){
			
			String storeName=e.getStoreName();
			if(storeName!=null){
				System.out.println("StoreName:"+e.getStoreName());
			}
		}
		System.out.println("===============");
		System.out.print("\n");
		
		System.out.println("===Menu===");
		System.out.println("1. Delete Favorite Product.");
		System.out.println("2. Delete Favorite Store.");
		System.out.println("3. Go Back.");
		System.out.println("4. Quit");
		
		int options=4;
		
		MainMenuView mainMenuView = new MainMenuView();
		int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
		
		FavoritesViewController favoritesViewController = new FavoritesViewController();
		favoritesViewController.controlAllFavoritesView(choice);
	}
}
