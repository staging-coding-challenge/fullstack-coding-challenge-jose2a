import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GroceryListComponent } from './components/grocery-list/grocery-list.component';
import { ItemListComponent } from './components/item-list/item-list.component';

const routes: Routes = [
  { path: '', redirectTo: '/grocery_list', pathMatch: 'full' },
  { path: 'grocery_list', component: GroceryListComponent },
  { path: 'grocery_list_items/:groceryListId', component: ItemListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
