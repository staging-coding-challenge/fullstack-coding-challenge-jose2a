package com.revature.grocery.list.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.grocery.list.dto.GroceryListDto;
import com.revature.grocery.list.model.GroceryList;
import com.revature.grocery.list.service.GroceryListService;

@RestController
@RequestMapping("/grocery-lists")
@CrossOrigin(origins = "*")
public class GroceryListController {

	private GroceryListService groceryListServ;
	private ModelMapper mapper;

	@Autowired
	public GroceryListController(GroceryListService groceryListServ, ModelMapper mapper) {
		super();
		this.groceryListServ = groceryListServ;
		this.mapper = mapper;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<GroceryListDto> getAllGroceryLists() {
		List<GroceryList> groceryLists = groceryListServ.getAllGroceryLists();

		List<GroceryListDto> list = new ArrayList<GroceryListDto>();

		groceryLists.stream().forEach(gl -> list.add(mapper.map(gl, GroceryListDto.class)));

		return list;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GroceryListDto> createGroceryList() {
		GroceryList groceryList = groceryListServ.createGroceryList();

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(mapper.map(groceryList, GroceryListDto.class));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteGroceryList(@PathVariable("id") Integer groceryListId) {
		boolean deleted = groceryListServ.deleteGroceryList(groceryListId);
		
		if (deleted) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GroceryListDto> getGroceryList(@PathVariable("id") Integer groceryListId) {
		GroceryList groceryList = groceryListServ.getGroceryListById(groceryListId);
		
		if (groceryList != null) {
			return ResponseEntity.status(HttpStatus.OK).body(mapper.map(groceryList, GroceryListDto.class));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

}
