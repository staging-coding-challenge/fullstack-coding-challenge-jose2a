package com.revature.grocery.list.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grocery_list")
public class GroceryList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grocery_list_id")
	private Integer groceryListId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "groceryList")
	private List<GroceryItem> groceryItems = new ArrayList<>();

	public GroceryList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroceryList(Integer groceryListId, List<GroceryItem> groceryItems) {
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

	public List<GroceryItem> getGroceryItems() {
		return groceryItems;
	}

	public void setGroceryItems(List<GroceryItem> groceryItems) {
		this.groceryItems = groceryItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groceryItems == null) ? 0 : groceryItems.hashCode());
		result = prime * result + ((groceryListId == null) ? 0 : groceryListId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryList other = (GroceryList) obj;
		if (groceryItems == null) {
			if (other.groceryItems != null)
				return false;
		} else if (!groceryItems.equals(other.groceryItems))
			return false;
		if (groceryListId == null) {
			if (other.groceryListId != null)
				return false;
		} else if (!groceryListId.equals(other.groceryListId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroceryList [groceryListId=" + groceryListId + ", groceryItems=" + groceryItems + "]";
	}

}
