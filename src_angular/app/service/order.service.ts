import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../model/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private urlbasic = '//localhost:8080';

  constructor(private http: HttpClient) { }

  public getOrders(idUser: number): Observable<any> {
    const url = `${this.urlbasic}/${idUser}/getOrders/`;
    return this.http.get(url);
  }

  public exportOrders(idUser: number): Observable<any> {
    const url = `${this.urlbasic}/${idUser}/admin/export`;
    return this.http.get(url);
  }

}
