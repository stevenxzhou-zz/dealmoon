package udel.cisc637.steven.controller;

import app.start.Start;
import udel.cisc637.steven.dao.SPCDao;
import udel.cisc637.steven.model.SPCModel;
import udel.cisc637.steven.view.MPCView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.SPCView;


public class SPCViewController {
	
	public void controlSPCView(int choice){
		switch(choice){
			case 1: seeProducts();
				break;
			case 2: goBackToMainCategories();
				break;
			case 3: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
		}
	}
	
	public void controlSPCViewAdmin(int choice){
		switch(choice){
			case 1: AddSubCategory();
				break;
			case 2: DeleteSubCategory();
				break;
			case 3: seeProducts();
				break;
			case 4: goBackToMainCategories();
				break;
			case 5: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
		}
	}
	
	public void seeProducts(){
		ProductsView productsView = new ProductsView();
		productsView.displayProductsFromSub(null);
	}
	
	public void goBackToMainCategories(){
		MPCView mpcView = new MPCView();
		mpcView.displayAllMainCategories();
	}
	
	public void AddSubCategory(){

		MainMenuView mainMenuView = new MainMenuView();
		String subProductName = mainMenuView.readstring(Start.AllowedInputTimes, "SubProductCategoryName");
		SPCView spcView = new SPCView();
		SPCDao spcDao = new SPCDao();
		SPCModel spc= new SPCModel();
		if(subProductName!=null){
			spc.setSubProductName(subProductName);
			spc.setMainProductName(Start.MainCategoryName);
		}
		spcDao.addSubCategory(spc);
		spcView.displaySubCategoriesFromMain(Start.MainCategoryName);
	}
	
	public void DeleteSubCategory(){
		MainMenuView mainMenuView = new MainMenuView();
		String subProductName = mainMenuView.readstring(Start.AllowedInputTimes, "SubProductCategoryName");
		SPCView spcView = new SPCView();
		SPCDao spcDao = new SPCDao();

		spcDao.deleteSubCategory(subProductName);
		spcView.displaySubCategoriesFromMain(Start.MainCategoryName);
			
	}
}
