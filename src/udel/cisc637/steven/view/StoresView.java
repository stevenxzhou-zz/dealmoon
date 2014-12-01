package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.StoresController;
import udel.cisc637.steven.model.StoresModel;

public class StoresView {
	public void displayAllStores(int items, int page) {
		NavigationView nv = new NavigationView();
		// TODO Auto-generated method stub
		StoresController StoresController = new StoresController();
		List<StoresModel> storesList= StoresController.getAllStores(items,page);
		System.out.print("\n");
		System.out.println("===Stores===");
		for(StoresModel e:storesList){
			System.out.println(e.getStoreName());
		}
		System.out.println("===Page"+page+"===");
		System.out.print("\n");
		
		nv.displayPagingMenu(Main.stores, Main.stores);
	}
	
public void displayStoreFromStoreName(String StoreName, int origin) {
		
		NavigationView nv = new NavigationView();
		
	    try {
	    	
	    	if(StoreName==null){
				System.out.print("Please Enter StoreName: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StoreName = br.readLine();
			}
	    	
	    	StoresController storesController = new StoresController();
			List<StoresModel> productsList= storesController.getStore(StoreName);
			System.out.print("\n");
			System.out.println("===Store===");
			for(StoresModel e:productsList){
				System.out.println("Store Name: "+e.getStoreName());
				System.out.println("Url: "+e.getStoreLink());
			}
			System.out.println("=============");
			System.out.print("\n");
			Main.setStoreName(StoreName);
			nv.displayPagingMenu(Main.store, Main.stores);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		
	}
	
	
}
