import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { apiConfig } from 'src/environments/environment';
import { GroceryItem } from '../models/grocery-item';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: "root"
})
export class GroceryItemService {
  apiUrl = `${apiConfig.url}items/`;

  constructor(private http: HttpClient) {}

  addItem(item: GroceryItem): Observable<GroceryItem> {
    return this.http.post<GroceryItem>(this.apiUrl, item, httpOptions);
  }

  removeItem(itemId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}${itemId}`, httpOptions);
  }
}
