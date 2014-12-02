package udel.cisc637.steven.controller;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.SPCView;

public class MPCViewController {
	
	public void controlMPCView(int choice){
		switch(choice){
			case 1: seeSubCategory();
				break;
			case 2: goBack();
				break;
			case 3: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
		}
	}
	
	public void seeSubCategory(){
		SPCView spcView = new SPCView();
		spcView.displaySubCategoriesFromMain(null);
	}
	
	public void goBack(){
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.displayMainMenu(Main.user);
	}
}
