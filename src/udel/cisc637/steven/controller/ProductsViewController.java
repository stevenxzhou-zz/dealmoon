package udel.cisc637.steven.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.dao.FavoritesDao;
import udel.cisc637.steven.dao.ProductsDao;
import udel.cisc637.steven.model.FavoritesModel;
import udel.cisc637.steven.model.ProductsModel;
import udel.cisc637.steven.view.FavoritesView;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.SPCView;

public class ProductsViewController {
	
	public void controlProductsFromSubView(int choice){
		
		if(Main.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: previouspage(Main.CurrentPageNumber);
					break;
				case 3: seeProduct();
					break;
				case 4: goBackToSubCategories();
					break;
				case 5: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
			}
		}else{
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: seeProduct();
					break;
				case 3: goBackToSubCategories();
					break;
				case 4: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
			}
		}
	}
	
	public void controlAllProductsView(int choice){
		
		if(Main.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: previouspage(Main.CurrentPageNumber);
					break;
				case 3: seeProduct();
					break;
				case 4: goBackToMainMenu();
					break;
				case 5: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
			}
		}else{
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: seeProduct();
					break;
				case 3: goBackToMainMenu();
					break;
				case 4: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
			}
		}
	}
	
	public void controlAllProductsViewAdmin(int choice){
		
		if(Main.CurrentPageNumber > 1){
			switch(choice){
				case 1: nextpage(Main.CurrentPageNumber);
					break;
				case 2: previouspage(Main.CurrentPageNumber);
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
					System.out.println("No Such Choice!");
			}
		}else{
			switch(choice){
			case 1: nextpage(Main.CurrentPageNumber);
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
				System.out.println("No Such Choice!");
		}
		}
	}

	

	public void controlProductFromProductIdView(int choice){
		if(Main.user.isAdmin()){
			switch(choice){
			case 1: deleteProduct(Main.ProductID);
				break;
			case 2: updateProduct(Main.ProductID);
				break;
			case 3: goBackToProducts();// go back to subcategory
				break;
			case 4: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
			
			}
		}else if(!Main.user.isAdmin()){
			switch(choice){
			case 1: addProductToFavorites();
				break;
			case 2: goBackToProducts();// go back to subcategory
				break;
			case 3: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
			
			}
		}else{
			switch(choice){
			case 1: goBackToProducts();// go back to subcategory
				break;
			case 2: System.exit(-1);
				break;
			default: 
				System.out.println("No Such Choice!");
			}
		}
		
	}
	
	public void seeProduct(){
		
		ProductsView productsView = new ProductsView();
		productsView.displayProductFromProductID(-1);
	}
	
	public void goBackToProducts(){
		
		ProductsView productsView = new ProductsView();
		productsView.displayProductsFromSub(Main.SubCategoryName);
	}
	
	public void goBackToSubCategories(){
		
		SPCView spcView = new SPCView();
		spcView.displaySubCategoriesFromMain(Main.MainCategoryName);
	}
	
	public void goBackToMainMenu(){
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.displayMainMenu(Main.user);
	}
	
	public void nextpage(int currentPage){
		
		ProductsView productsView = new ProductsView();
		Main.setCurrentPageNumber(Main.CurrentPageNumber+1);
		productsView.displayAllProducts(5, Main.CurrentPageNumber);
	}
	
	public void previouspage(int currentPage){

		ProductsView productsView = new ProductsView();
		Main.setCurrentPageNumber(Main.CurrentPageNumber-1);
		productsView.displayAllProducts(5, Main.CurrentPageNumber);
	}
	
	public void addProductToFavorites(){

		FavoritesDao favoritesDao = new FavoritesDao();
		FavoritesModel favorite = new FavoritesModel();
		favorite.setEmail(Main.user.getEmail());
		favorite.setProductID(Main.getProductID());
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			if(productID<0){
				
				System.out.print("Please Enter productID: ");
				productID = Integer.parseInt(br.readLine());
				if(productID!=-1){
					product.setProductID(productID);
				}
			}
			
			System.out.print("Please Enter ProductName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String ProductName = br.readLine();
			if(ProductName!=null){
				product.setProductName(ProductName);
			}
			System.out.print("Please Enter StoreName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String StoreName = br.readLine();
			if(StoreName!=null){
				product.setStoreName(StoreName);
			}
			
			System.out.print("Please Enter SubCategoryName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String SubCategoryName = br.readLine();
			if(SubCategoryName!=null){
				product.setSubCategoryName(SubCategoryName);
			}
			if(productsDao.getProduct(productID)!=null){
				System.out.print("Already Exist! ");
			}else{
				productsDao.addProduct(product);
			}
			
			productsView.displayAllProducts(5, Main.CurrentPageNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("Please input a nubmer as an ProductID");
		}
		
	
	}
	
	private void deleteProduct(int productID) {
		// TODO Auto-generated method stub
		ProductsDao productsDao = new ProductsDao();
		ProductsView productsView = new ProductsView();
		ProductsModel product = new ProductsModel();
		if(productID<0){
			try {
				System.out.print("Please Enter productID: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				productID = Integer.parseInt(br.readLine());
				if(productID!=-1){
					product.setProductID(productID);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e){
				System.out.println("Please input a nubmer as an ProductID");
			}
		}
		if(productsDao.getProduct(productID)!=null){
			productsDao.deleteProduct(productID);
		}else{
			System.out.print("Already Exist! ");
		}
		productsView.displayAllProducts(5, Main.CurrentPageNumber);
	}
	
	private void updateProduct(int productID) {
		// TODO Auto-generated method stub
		ProductsDao productsDao = new ProductsDao();
		ProductsView productsView = new ProductsView();
		ProductsModel product = new ProductsModel();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			if(productID<0){
				
				System.out.print("Please Enter productID: ");
				productID = Integer.parseInt(br.readLine());
				if(productID!=-1){
					product.setProductID(productID);
				}
			}
			
			System.out.print("Please Enter ProductName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String ProductName = br.readLine();
			if(ProductName!=null){
				product.setProductName(ProductName);
			}
			System.out.print("Please Enter StoreName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String StoreName = br.readLine();
			if(StoreName!=null){
				product.setStoreName(StoreName);
			}
			
			System.out.print("Please Enter SubCategoryName: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			String SubCategoryName = br.readLine();
			if(SubCategoryName!=null){
				product.setSubCategoryName(SubCategoryName);
			}
			if(productsDao.getProduct(productID)!=null){
				productsDao.updateProduct(product);
			}else{
				System.out.print("Wrong productID! ");
			}
			
			productsView.displayAllProducts(5, Main.CurrentPageNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e){
			System.out.println("Please input a nubmer as an ProductID");
		}
		
	}
	
}
