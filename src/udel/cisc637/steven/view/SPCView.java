package udel.cisc637.steven.view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.MPCViewController;
import udel.cisc637.steven.controller.SPCViewController;
import udel.cisc637.steven.dao.SPCDao;
import udel.cisc637.steven.model.SPCModel;

public class SPCView {
	
	public void displaySubCategoriesFromMain(String MainCategoryName) {
		
		// TODO Auto-generated method stub
		 try {
		    	if(MainCategoryName==null){
					System.out.print("Please Enter MainCategoryName: ");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					MainCategoryName = br.readLine();	
				}
				SPCDao spcDao = new SPCDao();
				List<SPCModel> spcList= spcDao.getAllSubCategories();
		
				System.out.print("\n");
				System.out.println("===Sub Categories===");
				for(SPCModel e:spcList){
					System.out.println(e.getSubProductName());
				}
				System.out.println("===================");
				System.out.print("\n");
				
				System.out.println("===Menu===");
				System.out.println("1. See Products User a SubCategory.");
				System.out.println("2. Go Back.");
				System.out.println("3. Quit");
				
				Main.setMainCategoryName(MainCategoryName);
				
				int options=3;
				MainMenuView mainMenuView = new MainMenuView();
				int choice=mainMenuView.readchoice(Main.AllowedInputTimes, options);
				
				SPCViewController spcViewController = new SPCViewController();
				spcViewController.controlSPCView(choice);
			}
		 	catch (IOException ioe) { 
		    	System.out.println("IO error trying to read your name!");
		    }
	}
}
