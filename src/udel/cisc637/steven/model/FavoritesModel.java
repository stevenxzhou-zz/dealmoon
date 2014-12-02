package udel.cisc637.steven.model;

import java.sql.Date;

public class FavoritesModel {
	public int FavID;
	public String Email;
	public int ProductID;
	public String StoreName;
	public Date AddDate;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public Date getAddDate() {
		return AddDate;
	}
	public void setAddDate(Date addDate) {
		AddDate = addDate;
	}
	public int getFavID() {
		return FavID;
	}
	public void setFavID(int favID) {
		FavID = favID;
	}
	
}
