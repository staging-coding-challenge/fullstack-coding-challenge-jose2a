import { Component, OnInit } from '@angular/core';
import { GroceryListService } from 'src/app/services/grocery-list.service';
import { GroceryList } from 'src/app/models/grocery-list';

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {

  groceryLists: GroceryList[];

  constructor(private groceryListServ: GroceryListService) { }

  ngOnInit() {
    this.groceryListServ.getGroceryLists().subscribe(list => {
      this.groceryLists = list;
    });
  }

}
