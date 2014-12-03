package app.start;

import udel.cisc637.steven.view.MainMenuView;

public class Start {

	// this is for traking the name of the category for going back to the previous menu.
	public static String MainCategoryName=null;
	public static String SubCategoryName=null;
	public static String StoreName=null;
	public static String Email=null;
	public static int ProductID=-1;
	public static boolean login=false;
	public static boolean Admin=false;
	public static String UserName="";
	// the initial page number is 1
	public static int CurrentPageNumber=1;
	
	// allowed input times or it will quit when it gets zero. 
	public static int AllowedInputTimes=3;
	
	public static void main(String[] args){
		
		MainMenuView mainMenuView = new MainMenuView();
		mainMenuView.displayGuestMainMenu();

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
		
		public static int getCurrentPageNumber() {
			return CurrentPageNumber;
		}
		public static void setCurrentPageNumber(int currentPageNumber) {
			CurrentPageNumber = currentPageNumber;
		}
		public static String getStoreName() {
			return StoreName;
		}
		public static void setStoreName(String storeName) {
			StoreName = storeName;
		}

		public static int getProductID() {
			return ProductID;
		}
		public static void setProductID(int productID) {
			ProductID = productID;
		}
		public static String getEmail() {
			return Email;
		}
		public static void setEmail(String email) {
			Email = email;
		}
		public static boolean isLogin() {
			return login;
		}
		public static void setLogin(boolean login) {
			Start.login = login;
		}
		public static boolean isAdmin() {
			return Admin;
		}
		public static void setAdmin(boolean admin) {
			Admin = admin;
		}
		public static String getUserName() {
			return UserName;
		}
		public static void setUserName(String userName) {
			UserName = userName;
		}
}
