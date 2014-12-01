package udel.cisc637.steven.view;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.MpcController;
import udel.cisc637.steven.model.MpcModel;

public class MpcView {
	
	public void displayAllMainCategories() {
		// TODO Auto-generated method stub
		MpcController mpcController = new MpcController();
		
		List<MpcModel> mpcList= mpcController.getAllMainCategories();
		
		System.out.print("\n");
		System.out.println("===Main Categories===");
		for(MpcModel e:mpcList){
			System.out.println(e.getMainProductName());
		}
		System.out.println("=====================");
		System.out.print("\n");
		
		NavigationView nv = new NavigationView();
		
		nv.displayNavigationMenu(Main.maincategories);
	}
}
