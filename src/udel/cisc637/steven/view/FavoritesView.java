package udel.cisc637.steven.view;

import java.util.List;

import udel.cisc637.steven.controller.FavoritesController;
import udel.cisc637.steven.model.FavoritesModel;

public class FavoritesView {
	public void displayAllFavorites() {
		// TODO Auto-generated method stub
		FavoritesController FavoritesController = new FavoritesController();
		List<FavoritesModel> favoritesList= FavoritesController.getAllFavorites();

		for(FavoritesModel e:favoritesList){
			System.out.println(e.getStoreName());
		}
	}
}
