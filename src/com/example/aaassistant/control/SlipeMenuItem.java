package com.example.aaassistant.control;

public class SlipeMenuItem {

	private int itemID;
	private String title;
	
	public SlipeMenuItem(int itemID, String title) {
		this.itemID = itemID;
		this.title = title;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
