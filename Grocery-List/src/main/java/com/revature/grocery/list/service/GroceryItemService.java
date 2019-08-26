package com.revature.grocery.list.service;

import com.revature.grocery.list.model.GroceryItem;

public interface GroceryItemService {

	public GroceryItem addGroceryItemToList(GroceryItem groceryItem);
	
	public boolean removeGroceryItemFromList(Integer itemId);
}
