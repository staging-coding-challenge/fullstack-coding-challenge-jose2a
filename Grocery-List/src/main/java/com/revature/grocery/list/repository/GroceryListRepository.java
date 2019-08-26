package com.revature.grocery.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.grocery.list.model.GroceryList;

public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {

}
