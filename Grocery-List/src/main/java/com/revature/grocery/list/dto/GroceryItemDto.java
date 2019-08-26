package com.revature.grocery.list.dto;

import javax.validation.constraints.NotEmpty;

public class GroceryItemDto {

	private Integer itemId;

	@NotEmpty(message = "Name required.")
	private String itemName;
	@NotEmpty(message = "Quantity required.")
	private Double itemQuantity;
	@NotEmpty(message = "Type required.")
	private String itemType;
	private Integer groceryListId;

	public GroceryItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroceryItemDto(Integer itemId, String itemName, Double itemQuantity, String itemType,
			Integer groceryListId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemType = itemType;
		this.groceryListId = groceryListId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Integer getGroceryListId() {
		return groceryListId;
	}

	public void setGroceryListId(Integer groceryListId) {
		this.groceryListId = groceryListId;
	}

	@Override
	public String toString() {
		return "GroceryItemDto [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity
				+ ", itemType=" + itemType + ", groceryListId=" + groceryListId + "]";
	}

}
