package com.revature.grocery.list.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.grocery.list.model.GroceryItem;
import com.revature.grocery.list.repository.GroceryItemRepository;

public class GroceryItemServiceImpl implements GroceryItemService {

	private GroceryItemRepository groceryItemRepo;

	@Autowired
	public GroceryItemServiceImpl(GroceryItemRepository groceryItemRepo) {
		super();
		this.groceryItemRepo = groceryItemRepo;
	}

	@Override
	public GroceryItem addGroceryItemToList(GroceryItem groceryItem) {
		groceryItemRepo.save(groceryItem);

		return groceryItem;
	}

	@Override
	public boolean removeGroceryItemFromList(Integer itemId) {
		try {
			groceryItemRepo.deleteById(itemId);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
