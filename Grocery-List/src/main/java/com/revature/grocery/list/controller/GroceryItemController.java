package com.revature.grocery.list.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.grocery.list.dto.GroceryItemDto;
import com.revature.grocery.list.model.GroceryItem;
import com.revature.grocery.list.model.GroceryList;
import com.revature.grocery.list.service.GroceryItemService;

@RestController
@RequestMapping("/grocery-lists/items")
public class GroceryItemController {

	private GroceryItemService groceryItemServ;
	private ModelMapper mapper;

	@Autowired
	public GroceryItemController(
			GroceryItemService groceryItemServ,
			ModelMapper mapper) {
		super();
		this.groceryItemServ = groceryItemServ;
		this.mapper = mapper;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GroceryItemDto> addGroceryItem(@RequestBody GroceryItemDto groceryItem) {
		GroceryItem groceryItemEntity = mapper.map(groceryItem, GroceryItem.class);
		groceryItemEntity.setGroceryList(new GroceryList(groceryItem.getGroceryListId()));
		
		GroceryItem returnedValue = groceryItemServ.addGroceryItemToList(groceryItemEntity);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(mapper.map(returnedValue, GroceryItemDto.class));

	}

	@DeleteMapping(value = "/{itemId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteGroceryItem(@PathVariable Integer itemId) {

		boolean deleted = groceryItemServ.removeGroceryItemFromList(itemId);

		if (deleted) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}

}
