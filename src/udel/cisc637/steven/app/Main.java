package udel.cisc637.steven.app;

import udel.cisc637.steven.view.MainMenuView;

public class Main {
	
	public static void main(String[] args){
		
		MainMenuView mmv = new MainMenuView();
		mmv.displayGuestMainMenu();
		
//		System.out.print("Enter MainProduct Category: ");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		 
//	    String MainCategoryName = null;
//	    try {
//	    	MainCategoryName = br.readLine();
//	    } catch (IOException ioe) {
//	    	System.out.println("IO error trying to read your name!");
//	    	System.exit(1);
//	    }
//		SpcView sv = new SpcView();
//		sv.displaySubCategoriesFromMain(MainCategoryName);
	}
}
