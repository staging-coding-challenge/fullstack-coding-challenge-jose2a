package com.revature.grocery.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.grocery.list.model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Integer> {

}
