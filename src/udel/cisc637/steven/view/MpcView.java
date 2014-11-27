package udel.cisc637.steven.view;
import java.util.List;

import udel.cisc637.steven.controller.MpcController;
import udel.cisc637.steven.model.MpcModel;

public class MpcView {
	
	private void displayAllMainCategories() {
		// TODO Auto-generated method stub
		MpcController mpcController = new MpcController();
		List<MpcModel> mpcList= mpcController.getAllMainCategories();

		for(MpcModel e:mpcList){
			System.out.println(e.getMainProductName());
		}
	}
	
	public static void main(String[] args){
		MpcView mv = new MpcView();
		mv.displayAllMainCategories();
	}
}
