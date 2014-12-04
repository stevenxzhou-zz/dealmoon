package udel.cisc637.steven.controller;

import app.start.Start;

import udel.cisc637.steven.dao.MPCDao;
import udel.cisc637.steven.model.MPCModel;
import udel.cisc637.steven.view.MPCView;
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
	
	public void controlMPCViewAdmin(int choice){
		switch(choice){
			case 1: AddMainCategory();
				break;
			case 2: DeleteMainCategory();
				break;
			case 3: seeSubCategory();
				break;
			case 4: goBack();
				break;
			case 5: System.exit(-1);
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
		mainMenuView.displayMainMenu(Start.getUserName());
	}
	
	public void AddMainCategory(){
		
		MainMenuView mainMenuView = new MainMenuView();
		String mainProductName = mainMenuView.readstring(Start.AllowedInputTimes, "MainProductCategoryName");
		MPCView mpcView = new MPCView();
		MPCDao mpcDao = new MPCDao();
		MPCModel mpc= new MPCModel();
		if(mainProductName!=null){
			mpc.setMainProductName(mainProductName);
		}
		mpcDao.addMainCategory(mpc);
		mpcView.displayAllMainCategories();
	}
	
	public void DeleteMainCategory(){

		MPCView mpcView = new MPCView();
		MPCDao mpcDao = new MPCDao();
		MainMenuView mainMenuView = new MainMenuView();
		String mainProductName = mainMenuView.readstring(Start.AllowedInputTimes, "MainProductCategoryName");
		mpcDao.deleteMainCategory(mainProductName);
		mpcView.displayAllMainCategories();
			
	}
}
