package com.revature.grocery.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.grocery.list.model.GroceryList;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {

}
