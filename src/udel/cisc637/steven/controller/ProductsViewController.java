package udel.cisc637.steven.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import app.start.Start;
import udel.cisc637.steven.dao.FavoritesDao;
import udel.cisc637.steven.dao.ProductsDao;
import udel.cisc637.steven.model.FavoritesModel;
import udel.cisc637.steven.model.ProductsModel;
import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.SPCView;
import udel.cisc637.steven.view.StoresView;

public class ProductsViewController {
	
	public void controlProductsFromSubView(int choice, int maxpages, int maxitems){

		if(Start.CurrentPageNumber>1&&Start.CurrentPageNumber!=maxpages){
			switch(choice){
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: previouspage(Start.CurrentPageNumber);
					break;
				case 3: seeProduct();
					break;
				case 4: goBackToSubCategories();
					break;
				case 5: System.exit(-1);
					break;
				default:
					goBackToProducts();
			}
		}
		else if(maxpages>1){
			switch(choice){
			case 1: nextpage(Start.CurrentPageNumber);
				break;
			case 2: seeProduct();
				break;
			case 3: goBackToSubCategories();
				break;
			case 4: System.exit(-1);
				break;
			default:
				goBackToProducts();
			}
		}
		else if(maxitems>1){
			switch(choice){
			case 1: seeProduct();
				break;
			case 2: goBackToSubCategories();
				break;
			case 3: System.exit(-1);
				break;
			default:
				goBackToProducts();
			}
		}else {
			switch(choice){
			case 1: goBackToSubCategories();
				break;
			case 2: System.exit(-1);
				break;
			default:
				goBackToProducts();
			}
		}
	}
	public void controlProductsFromStoreView(int choice, int maxpages, int maxitems){

		if(Start.CurrentPageNumber>1&&Start.CurrentPageNumber!=maxpages){
			switch(choice){
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: previouspage(Start.CurrentPageNumber);
					break;
				case 3: seeProduct();
					break;
				case 4: goBackToStore();
					break;
				case 5: System.exit(-1);
					break;
				default:
					goBackToProducts();
			}
		}
		else if(maxpages>1){
			switch(choice){
			case 1: nextpage(Start.CurrentPageNumber);
				break;
			case 2: seeProduct();
				break;
			case 3: goBackToStore();
				break;
			case 4: System.exit(-1);
				break;
			default:
				goBackToProducts();
			}
		}
		else if(maxitems>1){
			switch(choice){
			case 1: seeProduct();
				break;
			case 2: goBackToStore();
				break;
			case 3: System.exit(-1);
				break;
			default:
				goBackToProducts();
			}
		}else {
			switch(choice){
			case 1: goBackToStore();
				break;
			case 2: System.exit(-1);
				break;
			default:
				goBackToProducts();
			}
		}
	}
	
	public void controlAllProductsView(int choice){
		
		if(Start.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: previouspage(Start.CurrentPageNumber);
					break;
				case 3: seeProduct();
					break;
				case 4: goBackToMainMenu();
					break;
				case 5: System.exit(-1);
					break;
				default:
					goBackToProducts();
			}
		}else{
			switch(choice){
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: seeProduct();
					break;
				case 3: goBackToMainMenu();
					break;
				case 4: System.exit(-1);
					break;
				default:
					goBackToProducts();
			}
		}
	}
	
	public void controlAllProductsViewAdmin(int choice){
		
		if(Start.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Start.CurrentPageNumber);
					break;
				case 2: previouspage(Start.CurrentPageNumber);
					break;
				case 3: seeProduct();
					break;
				case 4: addProduct(-1);
					break;
				case 5: deleteProduct(-1);
					break;
				case 6: updateProduct(-1);
					break;
				case 7: goBackToMainMenu();
					break;
				case 8: System.exit(-1);
					break;
				default:
					goBackToProducts();
			}
		}else{
			switch(choice){
			case 1: nextpage(Start.CurrentPageNumber);
				break;
			case 2: seeProduct();
				break;
			case 3: addProduct(-1);
				break;
			case 4: deleteProduct(-1);
				break;
			case 5: updateProduct(-1);
				break;
			case 6: goBackToMainMenu();
				break;
			case 7: System.exit(-1);
				break;
			default:
				goBackToProducts();
		}
		}
	}

	

	public void controlProductFromProductIdView(int choice){
		if(Start.Admin){
			switch(choice){
			case 1: deleteProduct(Start.ProductID);
				break;
			case 2: updateProduct(Start.ProductID);
				break;
			case 3: goBackToProducts();// go back to subcategory
				break;
			case 4: System.exit(-1);
				break;
			default: 
				goBackToProducts();
			
			}
		}else if(!Start.Admin&&Start.login){
			switch(choice){
			case 1: addProductToFavorites();
				break;
			case 2: goBackToProducts();// go back to subcategory
				break;
			case 3: System.exit(-1);
				break;
			default: 
				goBackToProducts();
			
			}
		}else{
			switch(choice){
			case 1: goBackToProducts();// go back to subcategory
				break;
			case 2: System.exit(-1);
				break;
			default: 
				goBackToProducts();
			}
		}
		
	}
	
	public void seeProduct(){
		
		ProductsView productsView = new ProductsView();
		productsView.displayProductFromProductID(-1);
	}
	
	public void goBackToProducts(){
		
		ProductsView productsView = new ProductsView();
		if(Start.SubCategoryName!=null)
		{
			productsView.displayProductsFromSub(Start.getSubCategoryName());
			
		}else if(Start.StoreName!=null){
			
			productsView.displayProductsFromStoreName(Start.getStoreName());
		}else{
		
			productsView.displayAllProducts(5, Start.CurrentPageNumber);
		}
		
	}
	
	public void goBackToSubCategories(){
		
		SPCView spcView = new SPCView();
		spcView.displaySubCategoriesFromMain(Start.MainCategoryName);
	}
	
	public void goBackToMainMenu(){
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.displayMainMenu(Start.getUserName());
		Start.SubCategoryName=null;
	}

	public void goBackToStores(){
		
		StoresView storesView = new StoresView();
		storesView.displayAllStores(5, Start.CurrentPageNumber);
	}
	
	public void goBackToStore(){
		
		StoresView storesView = new StoresView();
		storesView.displayStoreFromStoreName(Start.StoreName);
	}
	
	
	public void nextpage(int currentPage){
		
		ProductsView productsView = new ProductsView();
		Start.setCurrentPageNumber(Start.CurrentPageNumber+1);
		productsView.displayAllProducts(5, Start.CurrentPageNumber);
	}
	
	public void previouspage(int currentPage){

		ProductsView productsView = new ProductsView();
		Start.setCurrentPageNumber(Start.CurrentPageNumber-1);
		productsView.displayAllProducts(5, Start.CurrentPageNumber);
	}
	
	public void addProductToFavorites(){

		FavoritesDao favoritesDao = new FavoritesDao();
		FavoritesModel favorite = new FavoritesModel();
		favorite.setFavID(0);
		favorite.setEmail(Start.getEmail());
		favorite.setProductID(Start.getProductID());
		java.util.Date today = new java.util.Date();
		favorite.setAddDate(new java.sql.Date(today.getTime()));
		favoritesDao.addFavorite(favorite);
		
		// return to products view
		FavoritesView favorites = new FavoritesView();
		favorites.displayAllFavorites();
	}
	

	private void addProduct(int productID) {
		// TODO Auto-generated method stub
		ProductsDao productsDao = new ProductsDao();
		ProductsView productsView = new ProductsView();
		ProductsModel product = new ProductsModel();
		MainMenuView mainMenuView = new MainMenuView();

		if(productID<0){
			
			productID = mainMenuView.readid(Start.AllowedInputTimes, "ProductID");
			if(productID!=-1){
				product.setProductID(productID);
			}
		}
		
		if(productsDao.getProduct(productID).getProductID()>0){
			
			System.out.print("Already Exist! Please try again!");
			addProduct(-1);
		}
	
		String ProductName = mainMenuView.readstring(Start.AllowedInputTimes, "ProductName");
		if(ProductName!=null){
			product.setProductName(ProductName);
		}

		String StoreName = mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");
		if(StoreName!=null){
			
			product.setStoreName(StoreName);
		}
		
		String SubCategoryName = mainMenuView.readstring(Start.AllowedInputTimes, "SubCategoryName");
		
		if(SubCategoryName!=null){
			product.setSubCategoryName(SubCategoryName);
		}
		
		String image = mainMenuView.readstring(Start.AllowedInputTimes, "Image FileName");
		
		if(image!=null){
			try {
				InputStream filecontent = new FileInputStream(image);
				product.setImage(filecontent);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		productsDao.addProduct(product);
		
		productsView.displayAllProducts(5, Start.CurrentPageNumber);
		
	}
	
	private void deleteProduct(int productID) {
		// TODO Auto-generated method stub
		ProductsDao productsDao = new ProductsDao();
		ProductsView productsView = new ProductsView();
		ProductsModel product = new ProductsModel();
		MainMenuView mainMenuView = new MainMenuView();
		
		if(productID<0){
			
			productID = mainMenuView.readid(Start.AllowedInputTimes, "ProductID");
			if(productID!=-1){
				product.setProductID(productID);
			}
		}
		
		if(productsDao.getProduct(productID)!=null){
			productsDao.deleteProduct(productID);
		}else{
			System.out.print("Already Exist! ");
		}
		productsView.displayAllProducts(5, Start.CurrentPageNumber);
	}
	
	private void updateProduct(int productID) {
		// TODO Auto-generated method stub
		ProductsDao productsDao = new ProductsDao();
		ProductsView productsView = new ProductsView();
		ProductsModel product = new ProductsModel();
		MainMenuView mainMenuView = new MainMenuView();
		
		if(productID<0){

			productID = mainMenuView.readid(Start.AllowedInputTimes, "ProductID");
			if(productID!=-1){
				product.setProductID(productID);
			}
		}
	
		String ProductName = mainMenuView.readstring(Start.AllowedInputTimes, "ProductName");
		if(ProductName!=null){
			product.setProductName(ProductName);
		}

		String StoreName = mainMenuView.readstring(Start.AllowedInputTimes, "StoreName");
		if(StoreName!=null){
			product.setStoreName(StoreName);
		}
		
		String SubCategoryName = mainMenuView.readstring(Start.AllowedInputTimes, "SubCategoryName");
		if(SubCategoryName!=null){
			product.setSubCategoryName(SubCategoryName);
		}
		
		String image = mainMenuView.readstring(Start.AllowedInputTimes, "Image FileName");
		
		if(image!=null){
			try {
				InputStream filecontent = new FileInputStream(image);
				product.setImage(filecontent);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(productsDao.getProduct(productID)!=null){
			productsDao.updateProduct(product);
		}else{
			System.out.print("Wrong productID! ");
		}
		
		productsView.displayAllProducts(5, Start.CurrentPageNumber);
		
	}
	
}
