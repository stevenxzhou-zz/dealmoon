package udel.cisc637.steven.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import app.start.Start;

import udel.cisc637.steven.dao.FavoritesDao;
import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.StoresView;

public class FavoritesViewController {
	public void controlAllFavoritesView(int choice){
		
		switch(choice){
			case 1: deleteFavoriteProduct();// go back to subcategory
				break;
			case 2: deleteFavoriteStore();// go back to subcategory
				break;
			case 3: goBackToProduct();// go back to subcategory
				break;
			case 4: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
		}
	}
	
	public void goBackToProduct(){
		if(Start.ProductID > 0){
			ProductsView productsView = new ProductsView();
			productsView.displayProductFromProductID(Start.getProductID());
			Start.ProductID=-1;
		}else if(Start.StoreName!=null)
		{
			StoresView storesView = new StoresView();
			storesView.displayStoreFromStoreName(Start.StoreName);
		}
		else{
			MainMenuView mainMenuView = new MainMenuView();
			mainMenuView.displayMainMenu(Start.UserName);
		}
		
	}
	
	public void deleteFavoriteStore(){
		FavoritesDao favoritesDao = new FavoritesDao();
		FavoritesView favoritesView = new FavoritesView();
		MainMenuView mainMenuView = new MainMenuView();
		
		String StoreName = mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");

		favoritesDao.deleteFavoriteStore(Start.getEmail(), StoreName);
		favoritesView.displayAllFavorites();
	}
	
	public void deleteFavoriteProduct(){
		
		FavoritesDao favoritesDao = new FavoritesDao();
		FavoritesView favoritesView = new FavoritesView();
		MainMenuView mainMenuView = new MainMenuView();
		
		int ProductID = mainMenuView.readid(Start.AllowedInputTimes, "ProductID");
		favoritesDao.deleteFavoriteProduct(Start.getEmail(), ProductID);
		favoritesView.displayAllFavorites();
	}
}
