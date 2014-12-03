package udel.cisc637.steven.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import app.start.Start;

import udel.cisc637.steven.controller.ProductsViewController;
import udel.cisc637.steven.dao.ProductsDao;
import udel.cisc637.steven.model.ProductsModel;

public class ProductsView {
	
	public void displayAllProducts(int items, int page) {
		
		// TODO Auto-generated method stub
		ProductsDao ProductsController = new ProductsDao();
		List<ProductsModel> productsList= ProductsController.getAllProducts(items,page);
		System.out.print("\n");
		System.out.println("===Products===");
		for(ProductsModel e:productsList){
			System.out.println(e.getProductID()+" "+e.getProductName());
		}
		System.out.println("===Page"+page+"===");
		System.out.print("\n");
		
		int options;
		
		if(Start.Admin&&Start.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Detail.");
			System.out.println("4. Add.");
			System.out.println("5. Delete.");
			System.out.println("6. Update.");
			System.out.println("7. Go Back.");
			System.out.println("8. Quit");
			options=8;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlAllProductsViewAdmin(choice);
		}
		
		if(Start.Admin&&Start.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Detail.");
			System.out.println("3. Add.");
			System.out.println("4. Delete.");
			System.out.println("5. Update.");
			System.out.println("6. Go Back.");
			System.out.println("7. Quit");
			options=7;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlAllProductsViewAdmin(choice);
		}
		
		
		if(!Start.Admin&&Start.CurrentPageNumber>1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. Previous Page");
			System.out.println("3. See Detail.");
			System.out.println("4. Go Back.");
			System.out.println("5. Quit");
			options=5;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlAllProductsView(choice);
		}
		
		if(!Start.Admin&&Start.CurrentPageNumber==1){
			System.out.println("===Menu===");
			System.out.println("1. Next Page.");
			System.out.println("2. See Detail.");
			System.out.println("3. Go Back.");
			System.out.println("4. Quit");
			options=4;
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlAllProductsView(choice);
		}
	}
	
	public void displayProductFromProductID(int ProductID) {
		
	    try {
	    	
	    	if(ProductID< 0){
				System.out.print("Please Enter ProductID: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				ProductID = (Integer.parseInt(br.readLine()));
			}
	    	
	    	ProductsDao productsDao = new ProductsDao();
			ProductsModel product = productsDao.getProduct(ProductID);
			
			System.out.print("\n");
			System.out.println("===Product===");
			System.out.println("Product Name: "+product.getProductName());
			System.out.println("Description: "+product.getProductDescritpion());
			System.out.println("Current Price: "+product.getCurrentPrice());
			System.out.println("List Price: "+product.getListPrice());
			System.out.println("Hits: "+product.getHits());
			System.out.println("=============");
			System.out.print("\n");
			
			int options;
			if(Start.login&&Start.Admin){
				System.out.println("===Menu===");
				System.out.println("1. Delete");
				System.out.println("2. Update");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				options=4;
			}else if(Start.login&&!Start.Admin){
				System.out.println("===Menu===");
				System.out.println("1. Add Product to Favorites.");
				System.out.println("2. Go Back.");
				System.out.println("3. Quit");
				options=3;
			}else{
				System.out.println("===Menu===");
				System.out.println("1. Go Back.");
				System.out.println("2. Quit");
				options=2;
			}
			Start.setProductID(ProductID);
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlProductFromProductIdView(choice);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
	}
	
	public void displayProductsFromSub(String SubCategoryName) {
		
	    try {
	    	if(SubCategoryName==null){
	    		System.out.print("Please Enter SubCategoryName: ");
	    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    		SubCategoryName = br.readLine();
		    }
	    	
	    	ProductsDao productsDao = new ProductsDao();
			List<ProductsModel> productsList = productsDao.getProductsFromSub(SubCategoryName);
			
			System.out.print("\n");
			System.out.println("===Products===");
			for(ProductsModel e: productsList){
				System.out.println(e.getProductID()+" "+e.getProductName());
			}
			System.out.println("===============");
			System.out.print("\n");
			
			int options;
			if(Start.CurrentPageNumber>1){
				Start.setSubCategoryName(SubCategoryName);
				System.out.println("===Menu===");
				System.out.println("1. Next Page.");
				System.out.println("2. Previous Page");
				System.out.println("3. See Detail.");
				System.out.println("4. Go Back.");
				System.out.println("5. Quit");
				
				options=5;
			}else{
				Start.setSubCategoryName(SubCategoryName);
				System.out.println("===Menu===");
				System.out.println("1. Next Page.");
				System.out.println("2. See Detail.");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				
				options=4;
			}
			
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlProductsFromSubView(choice);
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		// TODO Auto-generated method stub	
	}
	
	public void displayProductsFromStoreName(String StoreName, int origin) {
		
	    try {
	    	
	    	if(StoreName==null){
				System.out.print("Please Enter StoreName: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StoreName = br.readLine();
			}
	    	
	    	ProductsDao productsController = new ProductsDao();
			List<ProductsModel> productsList= productsController.getProductFromStoreName(StoreName);
			
			System.out.print("\n");
			System.out.println("===Products===");
			for(ProductsModel e: productsList){
				System.out.println(e.getProductID()+" "+e.getProductName());
			}
			System.out.println("==============");
			System.out.print("\n");
			
	    } catch (IOException ioe) {
	    	System.out.println("IO error trying to read your name!");
	    }
		
	}
}
