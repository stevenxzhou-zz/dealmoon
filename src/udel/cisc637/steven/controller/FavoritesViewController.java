package udel.cisc637.steven.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import app.start.Start;

import udel.cisc637.steven.dao.FavoritesDao;
import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.ProductsView;

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
		}else{
			MainMenuView mainMenuView = new MainMenuView();
			mainMenuView.displayMainMenu(Start.UserName);
		}
		
	}
	
	public void deleteFavoriteStore(){
		FavoritesDao favoritesDao = new FavoritesDao();
		FavoritesView favoritesView = new FavoritesView();
		try {
			System.out.print("Please Enter StoreName: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String StoreName = br.readLine();
			favoritesDao.deleteFavoriteStore(Start.getEmail(), StoreName);
			favoritesView.displayAllFavorites();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFavoriteProduct(){
		
		FavoritesDao favoritesDao = new FavoritesDao();
		FavoritesView favoritesView = new FavoritesView();
		try {
			System.out.print("Please Enter ProductID: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String ProductID = br.readLine();
			favoritesDao.deleteFavoriteProduct(Start.getEmail(), ProductID);
			favoritesView.displayAllFavorites();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
