package udel.cisc637.steven.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import udel.cisc637.steven.app.Main;
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
		mainMenuView.displayMainMenu(Main.getUserName());
	}
	
	public void AddMainCategory(){
		System.out.print("Please Enter New MainProductCategoryName: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mainProductName;
		MPCView mpcView = new MPCView();
		MPCDao mpcDao = new MPCDao();
		try {
			mainProductName = br.readLine();
			MPCModel mpc= new MPCModel();
			if(mainProductName!=null){
				mpc.setMainProductName(mainProductName);
			}
			mpcDao.addMainCategory(mpc);
			mpcView.displayAllMainCategories();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteMainCategory(){
		System.out.print("Please Enter a Known MainProductCategoryName: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mainProductName;
		MPCView mpcView = new MPCView();
		MPCDao mpcDao = new MPCDao();
		try {
			mainProductName = br.readLine();
			mpcDao.deleteMainCategory(mainProductName);
			mpcView.displayAllMainCategories();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
