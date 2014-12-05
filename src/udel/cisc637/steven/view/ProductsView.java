package udel.cisc637.steven.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import app.start.Start;

import udel.cisc637.steven.controller.ProductsViewController;
import udel.cisc637.steven.dao.ProductsDao;
import udel.cisc637.steven.model.ProductsModel;
import udel.cisc637.steven.utility.PageInfo;

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
		
	    	
	    	if(ProductID< 0){
				MainMenuView mainMenuView = new MainMenuView();
				ProductID=mainMenuView.readid(Start.AllowedInputTimes, "ProductID");
			}
	    	
	    	ProductsDao productsDao = new ProductsDao();
			ProductsModel product = productsDao.getProduct(ProductID);
			
			System.out.print("\n");
			System.out.println("===Product===");
			System.out.println("Product Name: "+product.getProductName());
			System.out.println("Description: "+product.getProductDescritpion());
			System.out.println("Current Price: "+product.getCurrentPrice());
			System.out.println("List Price: "+product.getListPrice());
			
			try {
				InputStream contentStream = product.getImage();
				OutputStream out=new FileOutputStream("images/"+product.getProductName()+".jpg");
				byte buf[]=new byte[1024];
			    int len;
			    while((len=contentStream.read(buf))>0)
			    	out.write(buf,0,len);
			    	out.close();
			} catch (FileNotFoundException e) {
				System.out.println("No Image Found");
			} catch (IOException e) {
				System.out.println("Error occured");
			}
			System.out.println("Image: "+product.getProductName()+".jpg has been downloaed!");
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
	}
	
	public void displayProductsFromSub(String SubCategoryName) {
		
	    	if(SubCategoryName==null){
	    		
	    		MainMenuView mainMenuView = new MainMenuView();
	    		mainMenuView.readstring(Start.AllowedInputTimes, "SubCategoryName");
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
			PageInfo pageInfo = new PageInfo(productsList,5); 
			int options;
			if(Start.CurrentPageNumber>1&&Start.CurrentPageNumber!=pageInfo.getMaxPages()){
				Start.setStoreName(SubCategoryName);
				System.out.println("===Menu===");
				System.out.println("1. Next Page.");
				System.out.println("2. Previous Page");
				System.out.println("3. See Detail.");
				System.out.println("4. Go Back.");
				System.out.println("5. Quit");
				
				options=5;
			}else if(pageInfo.getMaxPages()>1){
				Start.setStoreName(SubCategoryName);
				System.out.println("===Menu===");
				System.out.println("1. Next Page.");
				System.out.println("2. See Detail.");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				
				options=4;
			}else if(pageInfo.getMaxItems()>1){
				Start.setStoreName(SubCategoryName);
				System.out.println("===Menu===");
				System.out.println("1. See Detail.");
				System.out.println("2. Go Back.");
				System.out.println("3. Quit");
				
				options=3;
			}else{
				Start.setStoreName(SubCategoryName);
				System.out.println("No Products Belong to This Store!");
				System.out.println("===Menu===");
				System.out.println("1. Go Back.");
				System.out.println("2. Quit");
				
				options=2;
			}
			
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlProductsFromSubView(choice,pageInfo.getMaxPages(),pageInfo.getMaxItems());
	}
	
	public void displayProductsFromStoreName(String StoreName) {

			if(StoreName==null){
				MainMenuView mainMenuView = new MainMenuView();
				StoreName=mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");
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
			PageInfo pageInfo = new PageInfo(productsList,5); 
			int options;
			if(Start.CurrentPageNumber>1&&Start.CurrentPageNumber!=pageInfo.getMaxPages()){
				Start.setStoreName(StoreName);
				System.out.println("===Menu===");
				System.out.println("1. Next Page.");
				System.out.println("2. Previous Page");
				System.out.println("3. See Detail.");
				System.out.println("4. Go Back.");
				System.out.println("5. Quit");
				
				options=5;
			}else if(pageInfo.getMaxPages()>1){
				Start.setStoreName(StoreName);
				System.out.println("===Menu===");
				System.out.println("1. Next Page.");
				System.out.println("2. See Detail.");
				System.out.println("3. Go Back.");
				System.out.println("4. Quit");
				
				options=4;
			}else if(pageInfo.getMaxItems()>1){
				Start.setStoreName(StoreName);
				System.out.println("===Menu===");
				System.out.println("1. See Detail.");
				System.out.println("2. Go Back.");
				System.out.println("3. Quit");
				
				options=3;
			}else{
				Start.setStoreName(StoreName);
				System.out.println("No Products Belong to This Store!");
				System.out.println("===Menu===");
				System.out.println("1. Go Back.");
				System.out.println("2. Quit");
				
				options=2;
			}
			
			MainMenuView mainMenuView = new MainMenuView();
			int choice=mainMenuView.readchoice(Start.AllowedInputTimes, options);
			
			ProductsViewController productsViewController = new ProductsViewController();
			productsViewController.controlProductsFromStoreView(choice,pageInfo.getMaxPages(),pageInfo.getMaxItems());
	}
}

