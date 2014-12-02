package udel.cisc637.steven.controller;
import udel.cisc637.steven.view.MPCView;
import udel.cisc637.steven.view.ProductsView;


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
	
	public void seeProducts(){
		ProductsView productsView = new ProductsView();
		productsView.displayProductsFromSub(null);
	}
	
	public void goBackToMainCategories(){
		MPCView mpcView = new MPCView();
		mpcView.displayAllMainCategories();
	}
}
