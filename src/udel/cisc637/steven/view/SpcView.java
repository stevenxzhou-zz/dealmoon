package udel.cisc637.steven.view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.SpcController;
import udel.cisc637.steven.model.SpcModel;

public class SpcView {
	
	public void displayAllSubCategories() {
		// TODO Auto-generated method stub
		SpcController spcController = new SpcController();
		List<SpcModel> spcList= spcController.getAllSubCategories();
		NavigationView nv = new NavigationView();
		System.out.print("\n");
		System.out.println("===Sub Categories===");
		for(SpcModel e:spcList){
			
			System.out.println(e.getSubProductName());
		}
		System.out.println("===================");
		System.out.print("\n");
		nv.displayNavigationMenu(Main.subategories);
	}
	
	public void displaySubCategoriesFromMain(String MainCategoryName) {
		
		NavigationView nv = new NavigationView();
		
	    try {
	    	
	    	if(MainCategoryName==null){
				System.out.print("Please Enter MainCategoryName: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				MainCategoryName = br.readLine();
				
			}
	    	
	    	Main.setMainCategoryName(MainCategoryName);
	    	SpcController spcController = new SpcController();
			List<SpcModel> spcList= spcController.getSubCategoriesFromMain(MainCategoryName);
			System.out.print("\n");
			System.out.println("===Sub Categories===");
			for(SpcModel e:spcList){
				System.out.println(e.getSubProductName());
			}
			System.out.println("=====================");
			System.out.print("\n");
			nv.displayNavigationMenu(Main.subategories);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		// TODO Auto-generated method stub	
	}
}
