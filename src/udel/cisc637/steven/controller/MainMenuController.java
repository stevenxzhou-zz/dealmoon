package udel.cisc637.steven.controller;

import udel.cisc637.steven.view.MpcView;

public class MainMenuController {
	
	MpcView mv = new MpcView();
	
	public void guestMenu(int choice){
		switch(choice){
		case 1:
			break;
		case 2:
			break;
		case 3: mv.displayAllMainCategories();
			break;
		case 4:
			break;
		default:
			System.out.println("No Such Choice!");
		}
	}
}
