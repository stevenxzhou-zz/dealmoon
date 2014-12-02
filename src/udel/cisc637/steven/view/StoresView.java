package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.StoresViewController;
import udel.cisc637.steven.dao.StoresDao;
import udel.cisc637.steven.model.StoresModel;

public class StoresView {
	public void displayAllStores(int items, int page) {

		// TODO Auto-generated method stub
		StoresDao StoresController = new StoresDao();
		List<StoresModel> storesList= StoresController.getAllStores(items,page);
		System.out.print("\n");
		System.out.println("===Stores===");
		for(StoresModel e:storesList){
			System.out.println(e.getStoreName());
		}
		System.out.println("===Page"+page+"===");
		System.out.print("\n");
		
		int options=0;
		
		if(!Main.Admin&&Main.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Store by StoreName.");
			System.out.println("4. Go Back.");
			System.out.println("5. Quit");
			options=5;
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresView(choice);
		}
		
		if(!Main.Admin&&Main.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Store by StoreName.");
			System.out.println("3. Go Back.");
			System.out.println("4. Quit");
			options=4;
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresView(choice);
		}
		
		if(Main.Admin&&Main.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Store by StoreName.");
			System.out.println("4. Add.");
			System.out.println("5. Delete.");
			System.out.println("6. Update.");
			System.out.println("7. Go Back.");
			System.out.println("8. Quit");
			options=8;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresViewAdmin(choice);
		}
		
		if(Main.Admin&&Main.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Store by StoreName.");
			System.out.println("3. Add.");
			System.out.println("4. Delete.");
			System.out.println("5. Update.");
			System.out.println("6. Go Back.");
			System.out.println("7. Quit");
			options=7;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			
			StoresViewController storesViewController = new StoresViewController();
			storesViewController.controlAllStoresViewAdmin(choice);
		}
	}
	
	public void displayStoreFromStoreName(String StoreName) {
		
	    try {
	    	if(StoreName==null){
				System.out.print("Please Enter StoreName: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StoreName = br.readLine();
			}
	    	
	    	StoresDao storesDao = new StoresDao();
			StoresModel store= storesDao.getStore(StoreName);
			System.out.print("\n");
			System.out.println("===Store===");
			System.out.println("Store Name: "+store.getStoreName());
			System.out.println("Url: "+store.getStoreLink());
			System.out.println("===========");
			System.out.print("\n");
			
			if(Main.Admin){
				System.out.println("===Menu===");
				System.out.println("1. delete");
				System.out.println("2. update");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				Main.setStoreName(StoreName);

				int options=4;
				MainMenuView mainMenuView = new MainMenuView();
				int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
				
				StoresViewController storesViewController = new StoresViewController();
				storesViewController.controlStoreViewAdmin(choice);
			}else if(Main.login){
				System.out.println("===Menu===");
				System.out.println("1. Add store to favorites");
				System.out.println("2. Go Back.");
				System.out.println("3. Quit");
				int options=3;
				MainMenuView mainMenuView = new MainMenuView();
				int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
				
				StoresViewController storesViewController = new StoresViewController();
				storesViewController.controlStoreViewUser(choice);
			}else{
				System.out.println("===Menu===");
				System.out.println("1. Go Back.");
				System.out.println("2. Quit");
				Main.setStoreName(StoreName);

				int options=2;
				MainMenuView mainMenuView = new MainMenuView();
				int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
				
				StoresViewController storesViewController = new StoresViewController();
				storesViewController.controlStoreView(choice);
			}
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		
	}
	
	
}
