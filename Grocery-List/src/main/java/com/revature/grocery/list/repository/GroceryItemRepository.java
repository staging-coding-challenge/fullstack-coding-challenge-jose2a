package com.revature.grocery.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.grocery.list.model.GroceryItem;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Integer> {

}
