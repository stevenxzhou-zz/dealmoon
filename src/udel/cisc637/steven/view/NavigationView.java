package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.MainMenuController;
import udel.cisc637.steven.controller.MpcController;
import udel.cisc637.steven.controller.NavigationController;

public class NavigationView {
	
	NavigationController nvc = new NavigationController();
	MainMenuView mmv = new MainMenuView();
	
	public void displayPagingMenu(int currentState, int origin){
		System.out.println("===Menu===");
		int options=0;
		if(currentState==Main.product||currentState==Main.store){
			if(currentState==Main.product){
				System.out.println("1. Go Back.");
				System.out.println("2. Quit");
				options=2;
			}else if(currentState==Main.store){
				System.out.println("1. Checkout Products from this store.");
				System.out.println("2. Go Back.");
				System.out.println("3. Quit");
				options=3;
			}
			
		}else if(Main.currentpage>1){
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See More.");
			System.out.println("4. Go Back.");
			System.out.println("5. Quit");
			options=5;
		}else{
			System.out.println("1. Next Page.");
			System.out.println("2. See More.");
			System.out.println("3. Go Back.");
			System.out.println("4. Quit");
			options=4;
		}
		
	    int choice=mmv.readchoice(3, options);
	    nvc.nvGuestPagingMenu(choice, currentState, Main.currentpage, origin);  
	}
	
	public void displayNavigationMenu(int currentState){
		System.out.println("===Menu===");
		int options=0;
		if(currentState>3){
			System.out.println("1. Go Back.");
			System.out.println("2. Quit");
			options=2;
		}else{
			System.out.println("1. See More.");
			System.out.println("2. Go Back.");
			System.out.println("3. Quit");
			options=3;
		}
		int choice = mmv.readchoice(3, options);
		nvc.nvGuestMenu(choice, currentState);  
	}
}
