package com.revature.grocery.list.dto;

import java.util.List;

public class GroceryListDto {

	private Integer groceryListId;

	private List<GroceryItemDto> groceryItems;

	public GroceryListDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroceryListDto(Integer groceryListId, List<GroceryItemDto> groceryItems) {
		super();
		this.groceryListId = groceryListId;
		this.groceryItems = groceryItems;
	}

	public Integer getGroceryListId() {
		return groceryListId;
	}

	public void setGroceryListId(Integer groceryListId) {
		this.groceryListId = groceryListId;
	}

	public List<GroceryItemDto> getGroceryItems() {
		return groceryItems;
	}

	public void setGroceryItems(List<GroceryItemDto> groceryItems) {
		this.groceryItems = groceryItems;
	}

	@Override
	public String toString() {
		return "GroceryListDto [groceryListId=" + groceryListId + ", groceryItems=" + groceryItems + "]";
	}

}
