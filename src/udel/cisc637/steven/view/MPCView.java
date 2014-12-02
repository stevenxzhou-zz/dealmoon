package udel.cisc637.steven.view;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.MPCViewController;
import udel.cisc637.steven.dao.MPCDao;
import udel.cisc637.steven.model.MPCModel;

public class MPCView {
	
	public void displayAllMainCategories() {
		// TODO Auto-generated method stub
		MPCDao mpcDao = new MPCDao();
		
		List<MPCModel> mpcList= mpcDao.getAllMainCategories();
		
		// display all the main product categories
		System.out.print("\n");
		System.out.println("===Main Categories===");
		for(MPCModel e:mpcList){
			System.out.println(e.getMainProductName());
		}
		System.out.println("=====================");
		System.out.print("\n");
		
		//SubMenuView subMenuView = new SubMenuView();
		//subMenuView.displaySubMenu(Main.DisplayMainCategories, origin);
		
		if(Main.Admin){
			// display menus
			System.out.println("===Menu===");
			System.out.println("1. Add New MainCategory");
			System.out.println("2. Delete MainCategory");
			System.out.println("3. See SubCategory Under a MainCategory.");
			System.out.println("4. Go Back.");
			System.out.println("5. Quit");
			
			// control menus
			int options=5;
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			MPCViewController mpcViewController = new MPCViewController();
			mpcViewController.controlMPCViewAdmin(choice);
		}else{
			// display menus
			System.out.println("===Menu===");
			System.out.println("1. See SubCategory Under a MainCategory.");
			System.out.println("2. Go Back.");
			System.out.println("3. Quit");
			
			// control menus
			int options=3;
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
			MPCViewController mpcViewController = new MPCViewController();
			mpcViewController.controlMPCView(choice);
		}
		
	}
}
