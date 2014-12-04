package udel.cisc637.steven.utility;

import java.util.List;

public class PageInfo{
	private int MaxPages=0;
	private int MaxItems=0;
	
	public PageInfo(List list, int itemperpage){
		this.setMaxItems(list.size());
		this.setMaxPages(this.getMaxItems()/itemperpage);
	}

	public int getMaxPages() {
		return MaxPages;
	}

	public void setMaxPages(int maxPages) {
		MaxPages = maxPages;
	}

	public int getMaxItems() {
		return MaxItems;
	}

	public void setMaxItems(int maxItems) {
		MaxItems = maxItems;
	}
}