package udel.cisc637.steven.controller;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.view.MainMenuView;
import udel.cisc637.steven.view.MpcView;
import udel.cisc637.steven.view.ProductsView;
import udel.cisc637.steven.view.SpcView;
import udel.cisc637.steven.view.StoresView;

public class NavigationController {
	
	public void nvGuestPagingMenu(int choice, int currentState, int currentPage, int origin){

		if(currentState == Main.product||currentState == Main.store){
			
			if(currentState == Main.product){
				switch(choice){
				case 1: selectPreviousGuestMenu(currentState);
					break;
				case 2: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
				}
			}else if(currentState == Main.store){
				ProductsView pv = new ProductsView();
				switch(choice){
				case 1: pv.displayProductsFromStoreName(Main.getStoreName(), origin);
					break;
				case 2: selectPreviousGuestMenu(currentState);
					break;
				case 3: System.exit(-1);
					break;
				default:
					System.out.println("No Such Choice!");
				}
			}
			
			
		}else if(currentPage>1){
			switch(choice){
			case 1: nextpage(currentPage,currentState);
				break;
			case 2: previouspage(currentPage, currentState);
				break;
			case 3: currentFunction(currentState, origin);
				break;
			case 4: selectPreviousGuestMenu(1);
				break;
			case 5: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
			}
			
		}else{
			switch(choice){
			case 1: nextpage(currentPage,currentState);
				break;
			case 2: currentFunction(currentState,origin);
				break;
			case 3: selectPreviousGuestMenu(1);
				break;
			case 4: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
			}
		}
		
		
	}
	
	public void nextpage(int currentPage, int currentState){
		if(currentState==3){
			ProductsView pv = new ProductsView();
			Main.setCurrentpage(Main.currentpage+1);
			pv.displayAllProducts(5, Main.currentpage);
		}else if(currentState==5){
			StoresView sv = new StoresView();
			Main.setCurrentpage(Main.currentpage+1);
			sv.displayAllStores(5, Main.currentpage);
		}
	}
	
	public void previouspage(int currentPage, int currentState){
		if(currentState==3){
			ProductsView pv = new ProductsView();
			Main.setCurrentpage(Main.currentpage-1);
			pv.displayAllProducts(5, Main.currentpage);
		}else if(currentState==5){
			StoresView sv = new StoresView();
			Main.setCurrentpage(Main.currentpage-1);
			sv.displayAllStores(5, Main.currentpage);
		}
	}
	
	public void nvGuestMenu(int choice, int currentState){

		if(currentState > 3 ){
			
			switch(choice){
			case 1: selectPreviousGuestMenu(currentState);
				break;
			case 2: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
			}
			
		}else{
			switch(choice){
			case 1: currentFunction(currentState, Main.maincategories);
				break;
			case 2: selectPreviousGuestMenu(currentState);
				break;
			case 3: System.exit(-1);
				break;
			default:
				System.out.println("No Such Choice!");
			}
			
		}
		
	}
	
	public void selectPreviousGuestMenu(int currentState){
		MainMenuView mmv = new MainMenuView(); 
		MpcView mv = new MpcView();
		SpcView sv = new SpcView();
		ProductsView pv = new ProductsView();
		StoresView stv =  new StoresView();
		// whenever user go back, we recover the current page value to be 1.
		Main.setCurrentpage(1);
		
		switch(currentState){
			// currentState is MainProductCategoriesName, we need to go back to mainmenuview
			case 1: mmv.displayGuestMainMenu();
				break;
			// currentState is SubProductCategoriesName, we need to go back to maincategoriesview list
			case 2: mv.displayAllMainCategories();
				break;
			case 3: sv.displaySubCategoriesFromMain(Main.getMainCategoryName());
				break;
			case 4: pv.displayProductsFromSub(Main.getSubCategoryName());
				break;
			case 41: pv.displayAllProducts(5, 1);
				break;
			case 6: stv.displayAllStores(5, 1);
				break;
			default:
				mmv.displayGuestMainMenu();
		}
	}
	
	public void currentFunction(int currentState, int origin){
		MainMenuView mmv = new MainMenuView(); 
		SpcView sv = new SpcView();
		ProductsView pv= new ProductsView();
		StoresView stv = new StoresView();
		switch(currentState){
			// currentState is MainProductCategoriesName
			case 1: sv.displaySubCategoriesFromMain(null);
				break;
			// currentState is SubProductCategoriesName
			case 2: pv.displayProductsFromSub(null);
				break;
			// currentState is SubProductCategoriesName
			case 3: pv.displayProductFromProductID(null,origin);
				break;
			case 5: stv.displayStoreFromStoreName (null,origin);
				break;
			default:
				mmv.displayGuestMainMenu();
		}
	}
}
