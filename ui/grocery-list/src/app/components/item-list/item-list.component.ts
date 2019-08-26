import { Component, OnInit } from '@angular/core';
import { GroceryListService } from 'src/app/services/grocery-list.service';
import { GroceryList } from 'src/app/models/grocery-list';
import { ActivatedRoute } from '@angular/router';
import { GroceryItem } from 'src/app/models/grocery-item';
import { GroceryItemService } from 'src/app/services/grocery-item.service';

@Component({
  selector: "app-item-list",
  templateUrl: "./item-list.component.html",
  styleUrls: ["./item-list.component.css"]
})
export class ItemListComponent implements OnInit {
  groceryListId: number;
  groceryList = new GroceryList();
  groceryItem = new GroceryItem();
  errors: string[] = [];

  constructor(
    private groceryListServ: GroceryListService,
    private groceryItemServ: GroceryItemService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.groceryListId = +this.route.snapshot.paramMap.get("groceryListId");
    this.groceryListServ.getGroceryById(this.groceryListId).subscribe(list => {
      this.groceryList = list;
      this.groceryItem.groceryListId = list.groceryListId;
      this.clearForm();
    });
  }

  clearForm() {
    this.groceryItem.itemName = '';
    this.groceryItem.itemQuantity = 0;
    this.groceryItem.itemType = '';
  }

  addItem() {
    this.errors = [];

    if (this.groceryItem.itemName.length === 0) {
      this.errors.push('Item name is required');
    }

    if (this.groceryItem.itemQuantity <= 0) {
      this.errors.push('Item quatity should be greater than 0');
    }

    if (this.groceryItem.itemType.length === 0) {
      this.errors.push('Item type is required');
    }

    if (this.errors.length > 0) {
      return;
    }

    this.groceryItemServ.addItem(this.groceryItem).subscribe(item => {
      this.groceryList.groceryItems.push(item);
      this.clearForm();
    });
  }

  removeItem(item: GroceryItem) {
    console.log('Removing item' + item.itemId);
    this.groceryItemServ.removeItem(item.itemId).subscribe(() => {
      const index = this.groceryList.groceryItems.indexOf(item);
      this.groceryList.groceryItems.splice(index, 1);
    });
  }
}
