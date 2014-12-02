package udel.cisc637.steven.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.dao.SPCDao;
import udel.cisc637.steven.model.SPCModel;
import udel.cisc637.steven.view.MPCView;
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
		System.out.print("Please Enter New SubProductCategoryName: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String subProductName;
		SPCView spcView = new SPCView();
		SPCDao spcDao = new SPCDao();
		try {
			subProductName = br.readLine();
			SPCModel spc= new SPCModel();
			if(subProductName!=null){
				spc.setSubProductName(subProductName);
				spc.setMainProductName(Main.MainCategoryName);
			}
			spcDao.addSubCategory(spc);
			spcView.displaySubCategoriesFromMain(Main.MainCategoryName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteSubCategory(){
		System.out.print("Please Enter a Known SubProductCategoryName: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String subProductName;
		SPCView spcView = new SPCView();
		SPCDao spcDao = new SPCDao();
		try {
			subProductName = br.readLine();
			spcDao.deleteSubCategory(subProductName);
			spcView.displaySubCategoriesFromMain(Main.MainCategoryName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
