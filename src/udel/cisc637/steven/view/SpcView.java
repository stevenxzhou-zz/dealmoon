package udel.cisc637.steven.view;
import java.util.List;

import udel.cisc637.steven.controller.SpcController;
import udel.cisc637.steven.model.SpcModel;

public class SpcView {
	
	public void displayAllSubCategories() {
		// TODO Auto-generated method stub
		SpcController spcController = new SpcController();
		List<SpcModel> spcList= spcController.getAllSubCategories();

		for(SpcModel e:spcList){
			
			System.out.println(e.getSubProductName());
		}
	}
	
	public void displaySubCategoriesFromMain(String MainCategory) {
		// TODO Auto-generated method stub
		SpcController spcController = new SpcController();
		List<SpcModel> spcList= spcController.getSubCategoriesFromMain(MainCategory);

		for(SpcModel e:spcList){
			
			System.out.println(e.getSubProductName());
		}
	}
	

}
