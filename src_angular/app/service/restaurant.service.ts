import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private detailRestUrl = '//localhost:8080/restaurant/';
  private urlbasic = '//localhost:8080';

  ord: Order;

  constructor(private http: HttpClient) {
  }

  public getRestaurants(idUser: number): Observable<any> {
    const url = `${this.urlbasic}/${idUser}/restaurant/`;
    return this.http.get(url);
  }

  public getCat(idUser: number, idRestaurant: number): Observable<any> {
    const url = `${this.urlbasic}/${idUser}/restaurant/${idRestaurant}`;
    return this.http.get(url);
  }

  public getSubCat(idUser: number, idRestaurant: number, category: number): Observable<any> {
    const url = `${this.urlbasic}/${idUser}/restaurant/${idRestaurant}/${category}`;
    return this.http.get(url);
  }

  public placeOrder(idUser: number, idRestaurant: number, category: number, item: number): Observable<any> {
    console.log(item);
    const url = `${this.urlbasic}/${idUser}/restaurant/${idRestaurant}/${category}/${item}`;
    return this.http.post(url, this.ord);
  }

  public getOrders(idUser: number):Observable<Order[]>{
    const url = `${this.urlbasic}/${idUser}/admin/`;
    return this.http.get<Order[]>(url);
  }

  public changeStatus(order: Order, idUser: number):Observable<Order>{
    const url = `${this.urlbasic}/${idUser}/admin/`;
    return this.http.post<Order>(url, order);
  }
  
  
}
