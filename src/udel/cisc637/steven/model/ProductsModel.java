package udel.cisc637.steven.model;

import java.sql.Blob;
import java.sql.Date;

public class ProductsModel {
	public int ProductID;
	public String ProductName;
	public double ListPrice;
	public double CurrentPrice;
	public String ProductDescritpion;
	public Date AddDate;
	public Date ExpirationDate;
	public int Hits;
	public Blob Image;
	public String StoreName;
	public String SubCategoryName;
	
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getListPrice() {
		return ListPrice;
	}
	public void setListPrice(double listPrice) {
		ListPrice = listPrice;
	}
	public double getCurrentPrice() {
		return CurrentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		CurrentPrice = currentPrice;
	}
	public String getProductDescritpion() {
		return ProductDescritpion;
	}
	public void setProductDescritpion(String productDescritpion) {
		ProductDescritpion = productDescritpion;
	}
	public Date getAddDate() {
		return AddDate;
	}
	public void setAddDate(Date addDate) {
		AddDate = addDate;
	}
	public Date getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		ExpirationDate = expirationDate;
	}
	public int getHits() {
		return Hits;
	}
	public void setHits(int hits) {
		Hits = hits;
	}
	public Blob getImage() {
		return Image;
	}
	public void setImage(Blob image) {
		Image = image;
	}
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getSubCategoryName() {
		return SubCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		SubCategoryName = subCategoryName;
	}
}
