package udel.cisc637.steven.app;

import udel.cisc637.steven.view.MainMenuView;

public class Main {
	
	// this is for identifying user's access
	public static boolean isUser=false;
	public static boolean isAdmin=false;
	
	// this is for traking the name of the category for going back to the previous menu.
	public static String MainCategoryName=null;
	public static String SubCategoryName=null;
	public static String StoreName=null;
	//public static String ProductID=null;
	
	
	// this is for tracking the menu's current state
	public static final int maincategories=1;
	public static final int subategories=2;
	public static final int products=3;
	public static final int product=4;
	public static final int product1=41;
	public static final int stores=5;
	public static final int store=6;
	
	// this if for tracking the paging menu's current page
	public static int currentpage=1;
	
	
	public static void main(String[] args){
		
		MainMenuView mmv = new MainMenuView();
		mmv.displayGuestMainMenu();

		}
		public static boolean isUser() {
			return isUser;
		}
	
		public static void setUser(boolean isUser) {
			Main.isUser = isUser;
		}
	
		public static boolean isAdmin() {
			return isAdmin;
		}
	
		public static void setAdmin(boolean isAdmin) {
			Main.isAdmin = isAdmin;
		}
		public static String getMainCategoryName() {
			return MainCategoryName;
		}
		public static void setMainCategoryName(String mainCategoryName) {
			MainCategoryName = mainCategoryName;
		}
		public static String getSubCategoryName() {
			return SubCategoryName;
		}
		public static void setSubCategoryName(String subCategoryName) {
			SubCategoryName = subCategoryName;
		}
		
		public static void setCurrentpage(int currentpage) {
			Main.currentpage = currentpage;
		}
		public static int getCurrentpage() {
			return currentpage;
		}
		public static String getStoreName() {
			return StoreName;
		}
		public static void setStoreName(String storeName) {
			StoreName = storeName;
		}
}
