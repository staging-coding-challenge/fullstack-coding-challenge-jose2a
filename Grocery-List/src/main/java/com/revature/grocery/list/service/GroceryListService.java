package com.revature.grocery.list.service;

import java.util.List;

import com.revature.grocery.list.model.GroceryList;

public interface GroceryListService {
	public GroceryList createGroceryList();
	
	public boolean deleteGroceryList(Integer groceryListId);
	
	public GroceryList getGroceryListById(Integer groceryId);
	
	public List<GroceryList> getAllGroceryLists();

}
