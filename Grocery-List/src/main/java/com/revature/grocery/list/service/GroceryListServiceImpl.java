package com.revature.grocery.list.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.grocery.list.model.GroceryList;
import com.revature.grocery.list.repository.GroceryListRepository;

public class GroceryListServiceImpl implements GroceryListService {

	private GroceryListRepository groceryListRepo;

	@Autowired
	public GroceryListServiceImpl(GroceryListRepository groceryListRepo) {
		super();
		this.groceryListRepo = groceryListRepo;
	}

	@Override
	@Transactional
	public GroceryList createGroceryList() {
		GroceryList groceryList = new GroceryList();

		groceryListRepo.save(groceryList);

		return groceryList;
	}

	@Override
	@Transactional
	public boolean deleteGroceryList(Integer groceryListId) {
		try {
			groceryListRepo.deleteById(groceryListId);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<GroceryList> getAllGroceryLists() {
		return groceryListRepo.findAll();
	}

}
