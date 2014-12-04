package udel.cisc637.steven.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import app.start.Start;

import udel.cisc637.steven.dao.FavoritesDao;
import udel.cisc637.steven.dao.StoresDao;
import udel.cisc637.steven.model.FavoritesModel;
import udel.cisc637.steven.model.StoresModel;
import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.StoresView;

public class StoresViewController {
	
	public void controlAllStoresView(int choice){
		if(Start.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: previouspage(Start.CurrentPageNumber);
					break;
				case 3: seeStore();
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
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: seeStore();
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
	public void controlStoreView(int choice){
		switch(choice){
			case 1: seeProductsFromStore();
				break;
			case 2: goBackToStores();// go back to subcategory
				break;
			case 3: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
			
		}
	}
	
	public void controlStoreViewAdmin(int choice){
		switch(choice){
			case 1: deleteStore(Start.StoreName);
				break;
			case 2: updateStore(Start.StoreName);
				break;
			case 3: seeProductsFromStore();
				break;
			case 4: goBackToStores();// go back to subcategory
				break;
			case 5: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
		
		}
	}
	
	public void controlStoreViewUser(int choice){
		switch(choice){
			case 1: addStoreToFavorites();// go back to subcategory
				break;
			case 2: seeProductsFromStore();
				break;
			case 3: goBackToStores();// go back to subcategory
				break;
			case 4: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
		
		}
	}
	public void controlAllStoresViewAdmin(int choice){
		
		if(Start.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: previouspage(Start.CurrentPageNumber);
					break;
				case 3: seeStore();
					break;
				case 4: addStore(null);
					break;
				case 5: deleteStore(null);
					break;
				case 6: updateStore(null);
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
			case 1: nextpage(Start.CurrentPageNumber);
				break;
			case 2: seeStore();
				break;
			case 3: addStore(null);
				break;
			case 4: deleteStore(null);
				break;
			case 5: updateStore(null);
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
	
	public void goBackToMainMenu(){
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.displayMainMenu(Start.UserName);
	}
	
	public void goBackToStores(){
		
		StoresView storesView = new StoresView();
		storesView.displayAllStores(5, Start.CurrentPageNumber);
	}
	
	public void seeStore(){
		
		StoresView storesView = new StoresView();
		storesView.displayStoreFromStoreName(null);
	}
	
	public void seeProductsFromStore(){
		
		ProductsView productsView = new ProductsView();
		productsView.displayProductsFromStoreName(Start.StoreName);
	}
	
	public void nextpage(int currentPage){
		
		StoresView storesView = new StoresView();
		Start.setCurrentPageNumber(Start.CurrentPageNumber+1);
		storesView.displayAllStores(5, Start.CurrentPageNumber);
	}
	
	public void previouspage(int currentPage){

		StoresView storesView = new StoresView();
		Start.setCurrentPageNumber(Start.CurrentPageNumber-1);
		storesView.displayAllStores(5, Start.CurrentPageNumber);
	}
	
	public void addStoreToFavorites(){

		FavoritesDao favoritesDao = new FavoritesDao();
		FavoritesModel favorite = new FavoritesModel();
		favorite.setEmail(Start.getEmail());
		favorite.setStoreName(Start.getStoreName());
		java.util.Date today = new java.util.Date();
		favorite.setAddDate(new java.sql.Date(today.getTime()));
		favoritesDao.addFavorite(favorite);
		
		// return to products view
		FavoritesView favorites = new FavoritesView();
		favorites.displayAllFavorites();
	}
	
	private void addStore(String storeName) {
		// TODO Auto-generated method stub
		StoresDao storesDao = new StoresDao();
		StoresView storesView = new StoresView();
		StoresModel store = new StoresModel();
		MainMenuView mainMenuView = new MainMenuView();
		
		if(storeName==null){
			
			storeName = mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");
			if(storeName!=null){
				store.setStoreName(storeName);
			}
		}
		
		String storeLink = mainMenuView.readstring(Start.AllowedInputTimes, "StoreLink");
		
		if(storeLink!=null){
			store.setStoreLink(storeLink);
		}

		if(storesDao.getStore(storeName).StoreName!=null){
			System.out.print("Already Exist ");
		}else{
			storesDao.addStore(store);
		}
		
		storesView.displayAllStores(5, Start.CurrentPageNumber);
	
	}
	
	private void deleteStore(String storeName) {
		// TODO Auto-generated method stub
		StoresDao storesDao = new StoresDao();
		StoresView storesView = new StoresView();
		StoresModel store = new StoresModel();
		MainMenuView mainMenuView = new MainMenuView();
		if(storeName==null){
			storeName = mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");
			if(storeName!=null){
				store.setStoreName(storeName);
			}
		}
		if(storesDao.getStore(storeName)!=null){
			storesDao.deleteStore(storeName);
		}else{
			System.out.print("Already Exist! ");
		}
		storesView.displayAllStores(5, Start.CurrentPageNumber);
	}
	
	private void updateStore(String storeName) {
		// TODO Auto-generated method stub
		StoresDao storesDao = new StoresDao();
		StoresView storesView = new StoresView();
		StoresModel store = new StoresModel();
		MainMenuView mainMenuView = new MainMenuView();
		
		if(storeName==null){
			storeName = mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");
			if(storeName!=null){
				store.setStoreName(storeName);
			}
		}
		
		String storeLink = mainMenuView.readstring(Start.AllowedInputTimes, "StoreLink");
		if(storeLink!=null){
			store.setStoreLink(storeLink);
		}

		if(storesDao.getStore(storeName).getStoreName()!=null){
			storesDao.updateStore(store);
		}else{
			System.out.print("There is no store called " + storeName);
		}
		
		storesView.displayStoreFromStoreName(storeName);
	}
}
