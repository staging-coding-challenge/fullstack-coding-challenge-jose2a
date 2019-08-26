import { Injectable } from '@angular/core';
import { apiConfig } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GroceryList } from '../models/grocery-list';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: "root"
})
export class GroceryListService {
  apiUrl = apiConfig.url;

  constructor(private http: HttpClient) {}

  getGroceryLists(): Observable<GroceryList[]> {
    return this.http.get<GroceryList[]>(this.apiUrl);
  }

  getGroceryById(id: number): Observable<GroceryList> {
    return this.http.get<GroceryList>(`${this.apiUrl}${id}`);
  }
}
