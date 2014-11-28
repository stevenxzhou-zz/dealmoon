package udel.cisc637.steven.model;

import java.sql.Blob;

public class StoresModel {
	public String StoreName;
	public String StoreLink;
	public Blob StoreLogo;
	
	public String getStoreName() {
		return StoreName;
	}
	public void setStoreName(String storeName) {
		StoreName = storeName;
	}
	public String getStoreLink() {
		return StoreLink;
	}
	public void setStoreLink(String storeLink) {
		StoreLink = storeLink;
	}
	public Blob getStoreLogo() {
		return StoreLogo;
	}
	public void setStoreLogo(Blob storeLogo) {
		StoreLogo = storeLogo;
	}
	
}
