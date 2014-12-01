package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.controller.ProductsController;
import udel.cisc637.steven.controller.SpcController;
import udel.cisc637.steven.controller.StoresController;
import udel.cisc637.steven.model.ProductsModel;
import udel.cisc637.steven.model.SpcModel;
import udel.cisc637.steven.model.StoresModel;

public class ProductsView {
	
	public void displayAllProducts(int items, int page) {
		
		NavigationView nv = new NavigationView();
		
		// TODO Auto-generated method stub
		ProductsController ProductsController = new ProductsController();
		List<ProductsModel> productsList= ProductsController.getAllProducts(items,page);
		System.out.print("\n");
		System.out.println("===Products===");
		for(ProductsModel e:productsList){
			System.out.println(e.getProductID()+" "+e.getProductName());
		}
		System.out.println("=============");
		System.out.print("\n");
		
		nv.displayPagingMenu(Main.products, Main.products);
	}
	
	public void displayProductFromProductID(String ProductID, int origin) {
		
		NavigationView nv = new NavigationView();
		
	    try {
	    	
	    	if(ProductID==null){
				System.out.print("Please Enter ProductID: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				ProductID = br.readLine();
			}
	    	
	    	ProductsController productsController = new ProductsController();
			List<ProductsModel> productsList= productsController.getProduct(ProductID);
			System.out.print("\n");
			System.out.println("===Product===");
			for(ProductsModel e:productsList){
				System.out.println("Product Name: "+e.getProductName());
				System.out.println("Description: "+e.getProductDescritpion());
				System.out.println("Current Price: "+e.getCurrentPrice());
				System.out.println("List Price: "+e.getListPrice());
				System.out.println("Hits: "+e.getHits());
			}
			System.out.println("=============");
			System.out.print("\n");
			if(origin==Main.maincategories){
				nv.displayNavigationMenu(Main.product);
			}else if(origin==Main.products){
				nv.displayPagingMenu(Main.product1, origin);
			}
			
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		
	}
	
	public void displayProductsFromSub(String SubCategoryName) {
		
		NavigationView nv = new NavigationView();
		
	    try {
	    	if(SubCategoryName==null)
	    	{
	    		System.out.print("Please Enter SubCategoryName: ");
	    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    		SubCategoryName = br.readLine();
	    	}
	    	ProductsController productsController = new ProductsController();
			List<ProductsModel> productsList= productsController.getProductsFromSub(SubCategoryName);
			
			System.out.print("\n");
			System.out.println("===Products===");
			for(ProductsModel e: productsList){
				
				System.out.println(e.getProductID()+" "+e.getProductName());
			}
			System.out.println("====================");
			System.out.print("\n");
			
			nv.displayNavigationMenu(Main.products);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		// TODO Auto-generated method stub	
	}
	
	public void displayProductsFromStoreName(String StoreName, int origin) {
		
		NavigationView nv = new NavigationView();
		
	    try {
	    	
	    	if(StoreName==null){
				System.out.print("Please Enter StoreName: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StoreName = br.readLine();
			}
	    	
	    	ProductsController productsController = new ProductsController();
			List<ProductsModel> productsList= productsController.getProductFromStoreName(StoreName);
			
			System.out.print("\n");
			System.out.println("===Products===");
			for(ProductsModel e: productsList){
				
				System.out.println(e.getProductID()+" "+e.getProductName());
			}
			System.out.println("====================");
			System.out.print("\n");
			
			nv.displayPagingMenu(Main.store, Main.stores);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		
	}
}
